package com.software.tinyurl.core.http;

public enum HttpStatus {

    SUCCESS(200),
    UNAUTHORIZED(401),

    PERMISSION_DENIED(405),

    FIELD_ERROR(422),

    SYSTEM_ERROR(500);

    private int statusCd;

    HttpStatus(int i) {
        this.statusCd = i;
    }

    public int getStatusCd() {
        return this.statusCd;
    }
}
