package com.software.tinyurl.core.model.request;

public interface TinyUrlRequest {

    /**
     * Outs object as a JSON string, can be used to call HTTP endpoints
     * @return JSON representation of this object
     */
    public String toJson();

}
