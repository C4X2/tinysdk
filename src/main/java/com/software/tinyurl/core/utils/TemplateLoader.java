package com.software.tinyurl.core.utils;

import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class TemplateLoader {

    private static ClassLoader clzLdr = ClassLoader.getSystemClassLoader();

    public static final String NO_TEMPLATE = "_NO_TEMPLATE";

    private TemplateLoader(){
    }

    public static String jsonTemplate(String path){
        if (path == null || path.isEmpty()) return NO_TEMPLATE;

        try {
            InputStream ins = clzLdr.getResourceAsStream(path);
            String s = new String(ins.readAllBytes(), Charset.defaultCharset());
            ins.close();
            return s;
        } catch (Exception e) {}
        return NO_TEMPLATE;

    }
}
