/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.files.models.DirectConnectionInfo;

public class DirectConnectionInfoModel implements Serializable {
  public DirectConnectionInfoModel() {
  }

  public DirectConnectionInfoModel(final DirectConnectionInfo directConnectionInfo) {
    initGroup1(directConnectionInfo);
  }

  private void initGroup1(final DirectConnectionInfo directConnectionInfo) {
    this.version = directConnectionInfo.version;
    this.serverName = directConnectionInfo.serverName;
    this.addresses = directConnectionInfo.addresses != null ? Arrays.asList(directConnectionInfo.addresses) : null;
    this.directUri = directConnectionInfo.directUri;
    this.caPem = directConnectionInfo.caPem;
  }

  private Long version;

  public Long getVersion() {
    return version;
  }

  public void setVersion(final Long version) {
    this.version = version;
  }

  private String serverName;

  public String getServerName() {
    return serverName;
  }

  public void setServerName(final String serverName) {
    this.serverName = serverName;
  }

  private List<String> addresses;

  public List<String> getAddresses() {
    return addresses;
  }

  public void setAddresses(final List<String> addresses) {
    this.addresses = addresses;
  }

  private String directUri;

  public String getDirectUri() {
    return directUri;
  }

  public void setDirectUri(final String directUri) {
    this.directUri = directUri;
  }

  private String caPem;

  public String getCaPem() {
    return caPem;
  }

  public void setCaPem(final String caPem) {
    this.caPem = caPem;
  }

}
