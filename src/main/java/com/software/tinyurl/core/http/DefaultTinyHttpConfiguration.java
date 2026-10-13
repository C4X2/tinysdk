package com.software.tinyurl.core.http;

public class DefaultTinyHttpConfiguration implements TinyUrlHttpConfigurations{
    @Override
    public Long getDuration() {
        return 5000L;
    }

    @Override
    public Long getTimeout() {
        return 5000L;
    }

    @Override
    public boolean retry() {
        return false;
    }

    @Override
    public boolean followRedirects() {
        return true;
    }
}
