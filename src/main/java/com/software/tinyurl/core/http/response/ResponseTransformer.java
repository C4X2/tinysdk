package com.software.tinyurl.core.http.response;

public interface ResponseTransformer<C, I> {

    public C transform(I input);

    public I rawResponse();
}
