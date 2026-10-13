package com.software.tinyurl.core.model.response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CreateTinyUrlResponse implements TinyUrlResponse {

    private ResponseData data;

    private Integer code;

    private List<String> errors;

    public Integer getCode() {
        return code;
    }

    public ResponseData getData() {
        return this.data;
    }

    public List<String> getErrors() {
        return this.errors;
    }

    private CreateTinyUrlResponse(ResponseData responseData, Integer code, List<String> errors){
        this.data = responseData;
        this.code = code;
        this.errors = Collections.unmodifiableList(errors);
    }

    public static CreateTinyUrlResponseBuilder builder() {
        return new CreateTinyUrlResponseBuilder();
    }

    @Override
    public CreateTinyUrlResponse fromJson(String json) {
        // TODO
        return null;
    }

    public static class CreateTinyUrlResponseBuilder {
        private ResponseData data;

        private Integer code;

        private List<String> errors;

        private CreateTinyUrlResponseBuilder() {
            errors = new ArrayList<>();
        }

        public CreateTinyUrlResponseBuilder setCode(Integer code) {
            this.code = code;
            return this;
        }

        public CreateTinyUrlResponseBuilder setData(ResponseData data) {
            this.data = data;
            return this;
        }

        public CreateTinyUrlResponseBuilder setErrors(List<String> errors) {
            this.errors = errors;
            return this;
        }

        public CreateTinyUrlResponseBuilder addError(String error) {
            if (this.errors == null) this.errors = new ArrayList<>();
            errors.add(error);
            return this;
        }

        public CreateTinyUrlResponse build() {
            return new CreateTinyUrlResponse(this.data, this.code, this.errors);
        }
    }
}
