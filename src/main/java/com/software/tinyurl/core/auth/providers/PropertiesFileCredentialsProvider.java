package com.software.tinyurl.core.auth.providers;

import com.software.tinyurl.core.auth.cred.BasicTinyUrlCredentials;
import com.software.tinyurl.core.auth.cred.TinyUrlCredentials;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileCredentialsProvider implements TinyUrlCredentialsProvider {

    @Override
    public TinyUrlCredentials resolveCredentials() {
        try {
            Properties prop = new Properties();
            InputStream ins = this.getClass().getResourceAsStream("tinyurl.properties");
            prop.load(ins);
            return new BasicTinyUrlCredentials(prop.getProperty(TINY_URL_API), prop.getProperty(TINY_URL_API));
        } catch (Exception e) {}
        return null;
    }
}
