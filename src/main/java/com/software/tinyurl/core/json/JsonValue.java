package com.software.tinyurl.core.json;

public enum JsonValue {

    TRUE("true"),

    FALSE("false"),

    OBJECT("{"),

    ARRAY("["),

    NULL("null"),

    STRING("\""),

    NUMBER("");

    private String value;

    private JsonValue(String val)
    {
        this.value = val;
    }
}
