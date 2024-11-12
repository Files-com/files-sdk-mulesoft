package com.files.mule.internal.extension;

import static org.mule.runtime.api.meta.Category.CERTIFIED;

import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.runtime.extension.api.annotation.error.ErrorTypes;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

import com.files.mule.internal.connection.provider.FilesComConnectionProvider;
import com.files.mule.internal.error.FilesComErrorType;
import com.files.mule.internal.operation.FilesComOperations;

/**
 * EVERY FILE IN YOUR BUSINESS THROUGH ONE API AND APP Files.com is one single
 * API and App for all the Files in your business, no matter where they live.
 */
@Xml(prefix = "filescom")
@Extension(name = "Files.com", category = CERTIFIED, vendor = "Files.com")
@Operations(FilesComOperations.class)
@ConnectionProviders(FilesComConnectionProvider.class)
@ErrorTypes(FilesComErrorType.class)
@Summary("Configuration for Files.com")
public class FilesComConnector {
}