package com.software.tinyurl.core.auth.providers;

import com.software.tinyurl.core.auth.cred.TinyUrlCredentials;

/**
 * A credential provider will search different aspect of the environment to find applicable credentials
 */
@FunctionalInterface
public interface TinyUrlCredentialsProvider {

    public static final String TINY_URL_API = "TINY_URL_TOKEN";

    /**
     *
     * @return TinyUrlCredentials
     */
    public TinyUrlCredentials resolveCredentials();
}
