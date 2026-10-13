package com.software.tinyurl.core.http;

import com.software.tinyurl.core.auth.cred.TinyUrlAPICredentials;
import com.software.tinyurl.core.auth.cred.TinyUrlCredentials;
import com.software.tinyurl.core.http.response.ResponseTransformer;
import com.software.tinyurl.core.http.response.TinyUrlSimpleResponse;
import com.software.tinyurl.core.utils.MiscUtils;

import javax.net.ssl.SSLParameters;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.Flow;

public class TinyUrlHttpClient {

    private String baseUri;

    private HttpClient client;

    private TinyUrlHttpConfigurations cfg;

    private TinyUrlCredentials creds;

    public TinyUrlHttpClient(String baseUri, TinyUrlHttpConfigurations configs, TinyUrlCredentials creds)
    {
        this.baseUri = baseUri;
        client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMillis(configs.getDuration()))
                .followRedirects(getRedirectPolicy(configs))
                .build();
        this.cfg = configs;
        this.creds = creds;
    }

    private HttpClient.Redirect getRedirectPolicy(TinyUrlHttpConfigurations configs) {
        return configs.followRedirects() ? HttpClient.Redirect.NORMAL : HttpClient.Redirect.NEVER;
    }

    public TinyUrlSimpleResponse invoke(HttpMethod method, String uri, String body){
        String httpUri = MiscUtils.getOrDefault(this.baseUri,"") + uri + queryParams();
        Duration dur = Duration.ofMillis(this.cfg.getTimeout());
        HttpRequest.BodyPublisher bdy = HttpRequest.BodyPublishers.ofString(body);
        HttpRequest req = HttpRequest.newBuilder(URI.create(httpUri)).timeout(dur).method(method.name(), bdy).build();
        if (this.creds != null && this.creds.getBearerToken() != null){
            req = HttpRequest.newBuilder(req, (n,v) -> true).header("Authorization: Bearer",this.creds.getBearerToken()).build();
        }

        HttpResponse.BodyHandler<String> hndlr = HttpResponse.BodyHandlers.ofString();
        try {
            HttpResponse<String> resp = this.client.send(req, hndlr);
            return TinyUrlSimpleResponse.builder().status(resp.statusCode()).body(resp.body()).build();
        } catch (Exception e) {}

        return TinyUrlSimpleResponse.builder().status(500).body("").build();
    }

    private String queryParams() {
        if (creds == null || creds.getAPIKey() == null || creds.getAPIKey().isBlank()) return "";
        return "?api_token=" + creds.getAPIKey();
    }

}
