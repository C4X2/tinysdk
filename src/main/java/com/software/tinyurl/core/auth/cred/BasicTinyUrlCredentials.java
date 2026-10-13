package com.software.tinyurl.core.auth.cred;

public class BasicTinyUrlCredentials implements TinyUrlCredentials{
    private String apiKey;
    private String bearerToken;

    public BasicTinyUrlCredentials(String apiKey, String bearerToken)
    {
        this.apiKey = apiKey;
        this.bearerToken = bearerToken;
    }

    @Override
    public String getAPIKey() {
        return this.apiKey;
    }

    @Override
    public String getBearerToken() {
        return this.bearerToken;
    }
}
