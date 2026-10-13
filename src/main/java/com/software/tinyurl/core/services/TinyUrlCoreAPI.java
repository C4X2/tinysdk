package com.software.tinyurl.core.services;

import com.software.tinyurl.core.model.exception.*;
import com.software.tinyurl.core.model.request.*;
import com.software.tinyurl.core.model.response.*;

public interface TinyUrlCoreAPI {
    /**
     *
     * @param request
     * @return
     * @throws ImproperRequestException
     * @throws PermissionDeniedException
     * @throws UnauthorizedCreateException
     * @throws UnexpectedErrorException
     */
    public CreateTinyUrlResponse create(CreateTinyUrlRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedCreateException, UnexpectedErrorException;

    /**
     *
     * @param request
     * @return
     * @throws ImproperRequestException
     * @throws PermissionDeniedException
     * @throws UnauthorizedUpdateException
     * @throws UnexpectedErrorException
     */
    public UpdateTinyUrlResponse update(UpdateTinyUrlRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedUpdateException, UnexpectedErrorException;

    /**
     *
     * @param request
     * @return
     * @throws ImproperRequestException
     * @throws PermissionDeniedException
     * @throws UnauthorizedChangeException
     * @throws UnexpectedErrorException
     */
    public ChangeTinyUrlResponse change(ChangeTinyUrlRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedChangeException, UnexpectedErrorException;

    /**
     *
     * @param request
     * @return
     * @throws ImproperRequestException
     * @throws PermissionDeniedException
     * @throws UnauthorizedArchiveException
     * @throws UnexpectedErrorException
     */
    public ArchiveTinyUrlResponse archive(ArchiveTinyUrlRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedArchiveException, UnexpectedErrorException;

    /**
     * Endpoint allows to receive TinyURL information
     * @param request
     * @return
     * @throws ImproperRequestException
     * @throws PermissionDeniedException
     * @throws UnauthorizedDomainAliasException
     * @throws UnexpectedErrorException
     */
    public DomainAliasTinyUrlResponse getByDomainAlias(DomainAliasTinyUrlRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedDomainAliasException, UnexpectedErrorException;

    /**
     *
     * @param request
     * @return
     * @throws ImproperRequestException
     * @throws PermissionDeniedException
     * @throws UnauthorizedDeleteDomainAliasException
     * @throws UnexpectedErrorException
     */
    public DeleteDomainAliasTinyUrlResponse deleteByDomainAlias(DeleteDomainAliasTinyUrlRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedDeleteDomainAliasException, UnexpectedErrorException;

    /**
     *
     * @param request
     * @return
     * @throws ImproperRequestException
     * @throws PermissionDeniedException
     * @throws UnauthorizedListUrlsException
     * @throws UnexpectedErrorException
     */
    public ListTinyUrlsResponse listTinyUrls(ListTinyUrlsRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedListUrlsException, UnexpectedErrorException;

    /**
     *
     * @param request
     * @return
     * @throws ImproperRequestException
     * @throws PermissionDeniedException
     * @throws UnauthorizedCountUrlsException
     * @throws UnexpectedErrorException
     */
    public CountTinyUrlsResponse countTinyUrls(CountTinyUrlsRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedCountUrlsException, UnexpectedErrorException;

}
