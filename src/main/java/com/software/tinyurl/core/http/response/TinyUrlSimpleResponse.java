package com.software.tinyurl.core.http.response;

import java.util.ArrayList;
import java.util.List;

public class TinyUrlSimpleResponse {

    private int status;

    private String body;

    private List<String> errors;

    private TinyUrlSimpleResponse(int status, String body, List<String> errors) {
        this.status = status;
        this.body = body;
        this.errors = errors;
    }

    public int getStatus() {
        return this.status;
    }

    public String getBody() {
        return this.body;
    }

    public List<String> getErrors() {
        return this.errors;
    }

    public static TinyUrlSimpleResponseBuilder builder() {
        return new TinyUrlSimpleResponseBuilder();
    }

    public static class TinyUrlSimpleResponseBuilder {
        private int status;

        private String body;

        private List<String> errors;

        private TinyUrlSimpleResponseBuilder() {
            this.errors = new ArrayList<String>();
        }

        public TinyUrlSimpleResponseBuilder status(int status) {
            this.status = status;
            return this;
        }

        public TinyUrlSimpleResponseBuilder body(String body) {
            this.body = body;
            return this;
        }

        public TinyUrlSimpleResponseBuilder addError(String error) {
            this.errors.add(error);
            return this;
        }

        public TinyUrlSimpleResponse build() {
            return new TinyUrlSimpleResponse(status, body, errors);
        }
    }

}
