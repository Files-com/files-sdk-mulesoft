/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.extension;

import static org.mule.runtime.api.meta.Category.CERTIFIED;

import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.runtime.extension.api.annotation.error.ErrorTypes;
import org.mule.runtime.extension.api.annotation.license.RequiresEnterpriseLicense;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.sdk.api.annotation.JavaVersionSupport;

import com.files.mule.internal.connection.provider.FilesComConnectionProvider;
import com.files.mule.internal.error.FilesComErrorType;
import com.files.mule.internal.operation.FilesComOperations;

import static org.mule.sdk.api.meta.JavaVersion.JAVA_11;
import static org.mule.sdk.api.meta.JavaVersion.JAVA_17;
import static org.mule.sdk.api.meta.JavaVersion.JAVA_8;

/**
 * EVERY FILE IN YOUR BUSINESS THROUGH ONE API AND APP Files.com is one single
 * API and App for all the Files in your business, no matter where they live.
 */
@Xml(prefix = "filescom")
@Extension(name = "Files.com", category = CERTIFIED, vendor = "Files.com")
@JavaVersionSupport({JAVA_8, JAVA_11, JAVA_17})
@RequiresEnterpriseLicense(allowEvaluationLicense = true)
@Operations(FilesComOperations.class)
@ConnectionProviders(FilesComConnectionProvider.class)
@ErrorTypes(FilesComErrorType.class)
@Summary("Configuration for Files.com")
public class FilesComConnector {
}
