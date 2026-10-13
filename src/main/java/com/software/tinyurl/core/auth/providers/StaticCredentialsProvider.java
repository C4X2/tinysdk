package com.software.tinyurl.core.auth.providers;

import com.software.tinyurl.core.auth.cred.TinyUrlCredentials;

import java.util.Objects;

public class StaticCredentialsProvider implements TinyUrlCredentialsProvider {

    private TinyUrlCredentials tinyUrlCredentials;
    public StaticCredentialsProvider(TinyUrlCredentials tinyUrlCredentials)
    {
        Objects.requireNonNull(tinyUrlCredentials);
        this.tinyUrlCredentials = tinyUrlCredentials;
    }

    @Override
    public TinyUrlCredentials resolveCredentials() {
        return this.tinyUrlCredentials;
    }
}
