package com.software.tinyurl.bulk.model.request;

import com.software.tinyurl.core.model.request.TinyUrlRequest;

import java.util.ArrayList;
import java.util.List;

public class BulkCreateRequest implements TinyUrlRequest {
    private String domain;

    private List<BulkItem> items;

    public BulkCreateRequest(BulkCreateRequestBuilder builder) {
        this.domain = builder.domain;
        this.items = builder.items;
    }
    @Override
    public String toJson() {
        return null;
    }

    public static BulkCreateRequestBuilder builder() {
        return new BulkCreateRequestBuilder();
    }

    public static class BulkCreateRequestBuilder {
        private String domain;

        private List<BulkItem> items = new ArrayList<BulkItem>();

        public BulkCreateRequestBuilder domain(String domain)
        {
            this.domain = domain;
            return this;
        }

        public BulkCreateRequestBuilder addItem(BulkItem bulkItem)
        {
            this.items.add(bulkItem);
            return this;
        }

        public BulkCreateRequest build()
        {
            return new BulkCreateRequest(this);
        }
    }
}
