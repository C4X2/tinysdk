package com.software.tinyurl.core.model.response;

import java.util.Date;
import java.util.List;

public class ResponseData {
    private String domain;

    private String alias;

    private boolean deleted;

    private boolean archived;

    private AnalyticsResponseObject analyticsResponseObject;

    private List<String> tags;

    private Date createdAt;

    private Date expiresAt;

    private String tinyUrl;

    private String url;
}
