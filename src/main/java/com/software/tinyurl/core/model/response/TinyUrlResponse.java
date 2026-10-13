package com.software.tinyurl.core.model.response;

public interface TinyUrlResponse <T> {

    public T fromJson(String json);
}
