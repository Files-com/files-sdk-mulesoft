/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * A test-owned stand-in for Files.com and its storage, for one download only, on 127.0.0.1 and a port the system
 * chooses. Its API answers GET /api/rest/v1/files/{path} and GET /api/rest/v1/file_actions/metadata/{path} for the one
 * logical path it was started with, with that file's FileEntity: its path, type, exact size and a download_uri on this
 * same origin. Its storage answers a GET of that download_uri with the file's known bytes, their exact Content-Length
 * and application/octet-stream. It also answers the connector's connection validation, the listing of the root folder
 * FilesComConnectionProvider.validate() asks for, GET /api/rest/v1/folders/ with exactly the query pairs path, empty, and
 * per_page, 1, in either order, with the empty JSON listing [], since the fixture has no folder. Any other request, a
 * listing with any other query included, is refused and recorded, and fails assertDownloadServed().
 *
 * The file has no entity tag: a Range header is ignored, as HTTP allows, and the whole file is served with 200, never a
 * partial response; an If-Match other than * is refused with 412. Every handler answers at once, without waiting for
 * anything, and closes its exchange. close() stops only this fixture's server and settles only its own executor, each
 * within a bound.
 */
final class DownloadFixture implements AutoCloseable {
  /** The file's bytes: nonempty, and ASCII, so UTF-8 too. */
  static final byte[] CONTENT = "Files.com download fixture: 0123456789 abcdefghijklmnopqrstuvwxyz\n".getBytes(StandardCharsets.UTF_8);

  private static final String HOST = "127.0.0.1";
  private static final String API_PREFIX = "/api/rest/v1";
  private static final String FILES_PREFIX = API_PREFIX + "/files/";
  private static final String METADATA_PREFIX = API_PREFIX + "/file_actions/metadata/";
  private static final String FOLDERS_ROOT = API_PREFIX + "/folders/";
  private static final String STORAGE_PATH = "/storage/download-fixture";
  private static final String MTIME = "2000-01-01T01:00:00Z";
  private static final int STOP_DELAY_SECONDS = 1;
  private static final long SETTLE_SECONDS = 5;

  private final String logicalPath;
  private final byte[] content;
  private final HttpServer server;
  private final ExecutorService executor;
  private final String origin;
  private final List<String> requests = new ArrayList<String>();
  private final List<String> refused = new ArrayList<String>();
  private int validationServed;
  private int metadataServed;
  private int storageServed;
  private boolean closed;

  private DownloadFixture(String logicalPath, byte[] content, HttpServer server, ExecutorService executor) {
    this.logicalPath = logicalPath;
    this.content = content.clone();
    this.server = server;
    this.executor = executor;
    this.origin = "http://" + HOST + ":" + server.getAddress().getPort();
  }

  /** Starts a fixture for the file at logicalPath with content, on 127.0.0.1 and a free port. */
  static DownloadFixture start(String logicalPath, byte[] content) throws IOException {
    if (logicalPath == null || logicalPath.isEmpty() || content == null || content.length == 0) {
      throw new IllegalArgumentException("a download fixture needs a logical path and nonempty content");
    }

    final HttpServer server = HttpServer.create(new InetSocketAddress(InetAddress.getByName(HOST), 0), 0);
    final ExecutorService executor = Executors.newFixedThreadPool(2, runnable -> {
      final Thread thread = new Thread(runnable, "download-fixture");
      thread.setDaemon(true);
      return thread;
    });

    try {
      final DownloadFixture fixture = new DownloadFixture(logicalPath, content, server, executor);
      server.setExecutor(executor);
      server.createContext("/", fixture::handle);
      server.start();
      return fixture;
    } catch (RuntimeException error) {
      server.stop(0);
      executor.shutdownNow();
      throw error;
    }
  }

  /**
   * The origin, http://127.0.0.1:PORT: the SDK's apiRoot, or the connector's Base URL, to which the SDK appends
   * /api/rest/v1 itself.
   */
  String baseUrl() {
    return origin;
  }

  /** Every request the fixture received, in the order it received them. */
  synchronized List<String> requests() {
    return new ArrayList<String>(requests);
  }

  /**
   * Fails unless the fixture refused nothing, answered the connector's connection validation at least once, answered at
   * least one request for the file's FileEntity and served the whole file from its storage at least once. No order or
   * count of requests is required beyond that.
   */
  synchronized void assertDownloadServed() {
    if (!refused.isEmpty()) {
      throw new AssertionError("the download fixture refused " + refused + "; it received " + requests);
    }

    if (validationServed == 0) {
      throw new AssertionError("the connector's connection validation, GET " + FOLDERS_ROOT
          + " with path empty and per_page 1, never reached the download fixture; it received " + requests);
    }

    if (metadataServed == 0) {
      throw new AssertionError("no request for " + logicalPath + "'s FileEntity reached the download fixture; it received " + requests);
    }

    if (storageServed == 0) {
      throw new AssertionError("no storage GET of " + logicalPath + "'s content reached the download fixture; it received " + requests);
    }
  }

  /**
   * Closes the fixture once a test is over. first, when not null, is the test's own failure, which stays its outcome: a
   * failure to close is then added to it, suppressed. Otherwise a failure to close is thrown.
   */
  void closeAfter(Throwable first) {
    try {
      close();
    } catch (RuntimeException cleanup) {
      if (first == null) {
        throw cleanup;
      }

      first.addSuppressed(cleanup);
    }
  }

  /**
   * Stops this fixture's server, letting an exchange under way finish for up to a second, then settles its executor:
   * shut down, then interrupted if it has not finished, each waited for up to five seconds. Throws if it did not settle.
   */
  @Override
  public void close() {
    synchronized (this) {
      if (closed) {
        return;
      }

      closed = true;
    }

    server.stop(STOP_DELAY_SECONDS);
    executor.shutdown();

    try {
      if (!executor.awaitTermination(SETTLE_SECONDS, TimeUnit.SECONDS)) {
        executor.shutdownNow();

        if (!executor.awaitTermination(SETTLE_SECONDS, TimeUnit.SECONDS)) {
          throw new IllegalStateException("the download fixture's handler threads were still running after shutdown and interruption");
        }
      }
    } catch (InterruptedException interrupted) {
      executor.shutdownNow();
      Thread.currentThread().interrupt();
      throw new IllegalStateException("interrupted while the download fixture's executor settled", interrupted);
    }
  }

  private void handle(HttpExchange exchange) {
    try {
      final String method = exchange.getRequestMethod();
      final String path = exchange.getRequestURI().getPath();
      final String range = exchange.getRequestHeaders().getFirst("Range");
      record(method + " " + exchange.getRequestURI() + (range == null ? "" : " (Range: " + range + ")"));

      // A GET has no body; whatever came is not read, and closing the exchange closes it.
      final InputStream body = exchange.getRequestBody();
      body.close();

      if (!"GET".equals(method)) {
        refuse(exchange, 405, method + " " + path + " is not a GET");
      } else if (STORAGE_PATH.equals(path)) {
        serveStorage(exchange);
      } else if (FOLDERS_ROOT.equals(path)) {
        final String query = exchange.getRequestURI().getRawQuery();

        if (isValidationQuery(query)) {
          serveValidation(exchange);
        } else {
          refuse(exchange, 404, "GET " + path + " with query " + query + " is not the connector's connection validation");
        }
      } else if (logicalPath.equals(requestedPath(path))) {
        serveEntity(exchange);
      } else {
        refuse(exchange, 404, "GET " + path + " is not a request for " + logicalPath + " or its content");
      }
    } catch (IOException | RuntimeException error) {
      synchronized (this) {
        refused.add("a request failed in the fixture: " + error);
      }
    } finally {
      exchange.close();
    }
  }

  // Whether rawQuery is the query of the connector's connection validation: exactly the two pairs path, empty, and
  // per_page, 1, in either order, each with its =; a missing, repeated or other pair, or another value, is not.
  private static boolean isValidationQuery(String rawQuery) {
    if (rawQuery == null) {
      return false;
    }

    final Map<String, String> pairs = new HashMap<String, String>();

    for (final String pair : rawQuery.split("&", -1)) {
      final int equals = pair.indexOf('=');

      if (equals < 0) {
        return false;
      }

      final String name;
      final String value;

      try {
        name = URLDecoder.decode(pair.substring(0, equals), "UTF-8");
        value = URLDecoder.decode(pair.substring(equals + 1), "UTF-8");
      } catch (UnsupportedEncodingException | IllegalArgumentException malformed) {
        return false;
      }

      if (pairs.containsKey(name)) {
        return false;
      }

      pairs.put(name, value);
    }

    return pairs.size() == 2 && "".equals(pairs.get("path")) && "1".equals(pairs.get("per_page"));
  }

  // The logical path a request for a FileEntity names, or null for any other request.
  private static String requestedPath(String path) {
    if (path.startsWith(FILES_PREFIX)) {
      return path.substring(FILES_PREFIX.length());
    }

    if (path.startsWith(METADATA_PREFIX)) {
      return path.substring(METADATA_PREFIX.length());
    }

    return null;
  }

  // The connector's connection validation: its listing of the root folder, which the fixture, holding no folder,
  // answers as empty, the JSON array [] with its exact Content-Length.
  private void serveValidation(HttpExchange exchange) throws IOException {
    respond(exchange, 200, "application/json", "[]".getBytes(StandardCharsets.UTF_8));

    synchronized (this) {
      validationServed += 1;
    }
  }

  private void serveEntity(HttpExchange exchange) throws IOException {
    final String entity = "{\"path\":" + json(logicalPath)
        + ",\"type\":\"file\""
        + ",\"size\":" + content.length
        + ",\"mtime\":" + json(MTIME)
        + ",\"download_uri\":" + json(origin + STORAGE_PATH)
        + "}";
    respond(exchange, 200, "application/json", entity.getBytes(StandardCharsets.UTF_8));

    synchronized (this) {
      metadataServed += 1;
    }
  }

  private void serveStorage(HttpExchange exchange) throws IOException {
    final String ifMatch = exchange.getRequestHeaders().getFirst("If-Match");

    if (ifMatch != null && !"*".equals(ifMatch.trim())) {
      refuse(exchange, 412, "If-Match " + ifMatch + " names an entity tag the fixture's file does not have");
      return;
    }

    respond(exchange, 200, "application/octet-stream", content);

    synchronized (this) {
      storageServed += 1;
    }
  }

  private void refuse(HttpExchange exchange, int status, String reason) throws IOException {
    synchronized (this) {
      refused.add(reason);
    }

    final String error = "{\"error\":" + json(reason) + ",\"http-code\":" + status + "}";
    respond(exchange, status, "application/json", error.getBytes(StandardCharsets.UTF_8));
  }

  private static void respond(HttpExchange exchange, int status, String contentType, byte[] body) throws IOException {
    exchange.getResponseHeaders().set("Content-Type", contentType);
    exchange.sendResponseHeaders(status, body.length);

    try (OutputStream out = exchange.getResponseBody()) {
      out.write(body);
    }
  }

  private synchronized void record(String request) {
    requests.add(request);
  }

  private static String json(String value) {
    final StringBuilder out = new StringBuilder("\"");

    for (final char character : value.toCharArray()) {
      if (character == '"' || character == '\\') {
        out.append('\\').append(character);
      } else if (character < 0x20) {
        out.append(String.format("\\u%04x", (int) character));
      } else {
        out.append(character);
      }
    }

    return out.append('"').toString();
  }
}
