package com.software.tinyurl.core.http;

public interface TinyUrlHttpConfigurations {

    public Long getDuration();

    public Long getTimeout();

    public boolean retry();

    public boolean followRedirects();

}
