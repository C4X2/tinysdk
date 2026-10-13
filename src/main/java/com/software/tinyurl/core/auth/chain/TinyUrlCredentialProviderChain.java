package com.software.tinyurl.core.auth.chain;

import com.software.tinyurl.core.auth.cred.TinyUrlCredentials;

public interface TinyUrlCredentialProviderChain {

    public TinyUrlCredentials resolveCredentials();
}
