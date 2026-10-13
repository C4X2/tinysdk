package com.software.tinyurl.core.auth.providers;

import com.software.tinyurl.core.auth.cred.BasicTinyUrlCredentials;
import com.software.tinyurl.core.auth.cred.TinyUrlCredentials;

public class SystemVariableCredentialsProvider implements TinyUrlCredentialsProvider   {


    @Override
    public TinyUrlCredentials resolveCredentials() {
        try {
            String cred = System.getProperty(TINY_URL_API);
            return new BasicTinyUrlCredentials(cred, cred);
        } catch (Exception e) {}

        return null;
    }
}
