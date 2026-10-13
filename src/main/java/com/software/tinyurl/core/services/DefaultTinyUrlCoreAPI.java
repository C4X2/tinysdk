package com.software.tinyurl.core.services;

import com.software.tinyurl.core.auth.chain.DefaultTinyCredentialProviderChain;
import com.software.tinyurl.core.auth.cred.TinyUrlCredentials;
import com.software.tinyurl.core.auth.providers.TinyUrlCredentialsProvider;
import com.software.tinyurl.core.http.*;
import com.software.tinyurl.core.http.response.TinyUrlSimpleResponse;
import com.software.tinyurl.core.model.exception.*;
import com.software.tinyurl.core.model.request.*;
import com.software.tinyurl.core.model.response.*;

import java.util.List;
import java.util.Objects;

public class DefaultTinyUrlCoreAPI implements TinyUrlCoreAPI{
   private TinyUrlCredentials credentials;

   private TinyUrlHttpConfigurations httpConfigurations;

   private TinyUrlHttpClient client;

   private DefaultTinyUrlCoreAPI(TinyUrlCredentials credentials) {
       this(credentials, new DefaultTinyHttpConfiguration());
   }

   private DefaultTinyUrlCoreAPI(TinyUrlCredentials credentials, TinyUrlHttpConfigurations httpConfigurations){
       this.credentials = credentials;
       this.httpConfigurations = httpConfigurations;
       this.client = new TinyUrlHttpClient("https://api.tinyurl.com", httpConfigurations, credentials);
   }

    @Override
    public CreateTinyUrlResponse create(CreateTinyUrlRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedCreateException, UnexpectedErrorException {

        TinyUrlSimpleResponse smp = this.client.invoke(HttpMethod.POST, "/create", request.toJson());
        checkCommonErrors(smp);
        if (smp.getStatus() == HttpStatus.UNAUTHORIZED.getStatusCd()) throw new UnauthorizedCreateException();

        //TODO
        //CreateTinyUrlResponse.builder().
        return null;
    }

    @Override
    public UpdateTinyUrlResponse update(UpdateTinyUrlRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedUpdateException, UnexpectedErrorException {
        TinyUrlSimpleResponse smp = this.client.invoke(HttpMethod.POST, "/update", request.toJson());
        checkCommonErrors(smp);
        if (smp.getStatus() == HttpStatus.UNAUTHORIZED.getStatusCd()) throw new UnauthorizedUpdateException();

        //TODO
        return null;
    }

    @Override
    public ChangeTinyUrlResponse change(ChangeTinyUrlRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedChangeException, UnexpectedErrorException {
        TinyUrlSimpleResponse smp = this.client.invoke(HttpMethod.POST, "/change", request.toJson());
        checkCommonErrors(smp);
        if (smp.getStatus() == HttpStatus.UNAUTHORIZED.getStatusCd()) throw new UnauthorizedUpdateException();

       //TODO
        return null;
    }

    @Override
    public ArchiveTinyUrlResponse archive(ArchiveTinyUrlRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedArchiveException, UnexpectedErrorException {
        TinyUrlSimpleResponse smp = this.client.invoke(HttpMethod.POST, "/archive", request.toJson());
        checkCommonErrors(smp);
        if (smp.getStatus() == HttpStatus.UNAUTHORIZED.getStatusCd()) throw new UnauthorizedArchiveException();

        //TODO
        return null;
    }

    @Override
    public DomainAliasTinyUrlResponse getByDomainAlias(DomainAliasTinyUrlRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedDomainAliasException, UnexpectedErrorException {
       String urlSuffix =  "/alias/" + request.getDomain() + "/" + request.getAlias();
       TinyUrlSimpleResponse smp = this.client.invoke(HttpMethod.POST, urlSuffix, null);
        checkCommonErrors(smp);
        if (smp.getStatus() == HttpStatus.UNAUTHORIZED.getStatusCd()) throw new UnauthorizedDomainAliasException();

       //TODO
        return null;
    }

    @Override
    public DeleteDomainAliasTinyUrlResponse deleteByDomainAlias(DeleteDomainAliasTinyUrlRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedDeleteDomainAliasException, UnexpectedErrorException {
        return null;
    }

    @Override
    public ListTinyUrlsResponse listTinyUrls(ListTinyUrlsRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedListUrlsException, UnexpectedErrorException {
        return null;
    }

    @Override
    public CountTinyUrlsResponse countTinyUrls(CountTinyUrlsRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedCountUrlsException, UnexpectedErrorException {
        return null;
    }

    public static TinyUrlCoreAPI create()
    {
        return create(new DefaultTinyHttpConfiguration());
    }

    public static TinyUrlCoreAPI create(TinyUrlHttpConfigurations cfg)
    {
        Objects.requireNonNull(cfg, "cfg cannot be null");
        TinyUrlCredentials t = new DefaultTinyCredentialProviderChain().resolveCredentials();
        if (t == null) throw new NoCredentialsFoundException();
        return new DefaultTinyUrlCoreAPI(t, cfg);
    }

    public static TinyUrlCoreAPI create(TinyUrlCredentialsProvider provider)
    {
        return create(provider, new DefaultTinyHttpConfiguration());
    }

    public static TinyUrlCoreAPI create(TinyUrlCredentialsProvider provider, TinyUrlHttpConfigurations cfg)
    {
        Objects.requireNonNull(provider, "provider cannot be null");
        Objects.requireNonNull(cfg, "cfg cannot be null");
        TinyUrlCredentials t = provider.resolveCredentials();
        if (t == null) throw new NoCredentialsFoundException();
        return new DefaultTinyUrlCoreAPI(t, cfg);
    }

    private void checkCommonErrors(TinyUrlSimpleResponse smp) {
        if (smp == null) throw new UnexpectedErrorException();
        if (smp.getStatus() == HttpStatus.PERMISSION_DENIED.getStatusCd()) throw new PermissionDeniedException();
        if (smp.getStatus() == HttpStatus.FIELD_ERROR.getStatusCd()) throw new ImproperRequestException(smp.getErrors());
        if (smp.getStatus() == HttpStatus.SYSTEM_ERROR.getStatusCd()) throw new UnexpectedErrorException();
    }
}
