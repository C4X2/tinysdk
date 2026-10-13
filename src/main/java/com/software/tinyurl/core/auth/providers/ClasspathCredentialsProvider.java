package com.software.tinyurl.core.auth.providers;

import com.software.tinyurl.core.auth.cred.BasicTinyUrlCredentials;
import com.software.tinyurl.core.auth.cred.TinyUrlCredentials;

import java.io.InputStream;

public class ClasspathCredentialsProvider implements TinyUrlCredentialsProvider{
    @Override
    public TinyUrlCredentials resolveCredentials() {
        try {
            InputStream ins = this.getClass().getClassLoader().getResourceAsStream("tinyurltoken.txt");
            String cred = ins.toString();
            return new BasicTinyUrlCredentials(cred, cred);
        } catch (Exception e) {}
        return null;
    }
}
