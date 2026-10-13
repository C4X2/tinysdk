package com.software.tinyurl.core.auth.chain;

import com.software.tinyurl.core.auth.cred.TinyUrlCredentials;
import com.software.tinyurl.core.auth.providers.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Check java system paramters
 * 2. Check environment variables
 * 3. Check classpath for tinyurltoken.txt
 * 4. Check tinyurl.properties API_TOKEN
 */
public class DefaultTinyCredentialProviderChain implements TinyUrlCredentialProviderChain {
    List<TinyUrlCredentialsProvider> providers;

    public DefaultTinyCredentialProviderChain()
    {
        providers = new ArrayList<TinyUrlCredentialsProvider>();
        providers.addAll(List.of(
                new SystemVariableCredentialsProvider(),
                new EnvironmentVariableCredentialsProvider(),
                new ClasspathCredentialsProvider(),
                new PropertiesFileCredentialsProvider()
        ));
    }

    @Override
    public TinyUrlCredentials resolveCredentials() {
        for (TinyUrlCredentialsProvider tucp: providers)
        {
            TinyUrlCredentials tcp = tucp.resolveCredentials();
            if(tcp != null && (tcp.getAPIKey() != null || tcp.getBearerToken() != null)) return tcp;
        }
        return null;
    }
}
