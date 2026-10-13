package com.software.tinyurl.core.json;

import java.lang.reflect.Field;
import java.util.Objects;

public class JsonUtil {
    private JsonUtil() {}

    public static <T> T transform(String json, Class<T> clazz) throws NullPointerException {
        Objects.requireNonNull(clazz);
        if (json == null || json.isBlank()) return null;

        Field[] fields = clazz.getDeclaredFields();
        //for ()


        return null;
    }
}
