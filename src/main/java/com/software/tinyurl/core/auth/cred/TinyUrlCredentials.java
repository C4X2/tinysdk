package com.software.tinyurl.core.auth.cred;

/**
 * This is a store for TinyUrlCredentials. To generate an API key go to https://tinyurl.com/app/settings/api.
 * TinyUrl uses the generated API Key as a bearer token/api key. They are interchangable.
 */
public interface TinyUrlCredentials extends TinyUrlAPICredentials, TinyUrlBearerToken{
}
