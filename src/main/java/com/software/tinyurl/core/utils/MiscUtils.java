package com.software.tinyurl.core.utils;

public class MiscUtils {
    private MiscUtils(){}

    public static String safeToString(Object o, String dfault){
        return getOrDefault(o, dfault).toString();
    }

    public static <T> T getOrDefault(T originVal, T defualt ){
        if (originVal == null) return defualt;
        return originVal;
    }
}
