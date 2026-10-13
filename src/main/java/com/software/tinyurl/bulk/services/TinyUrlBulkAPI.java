package com.software.tinyurl.bulk.services;

import com.software.tinyurl.bulk.model.exception.UnauthorizedBulkCreateException;
import com.software.tinyurl.bulk.model.exception.UnauthorizedBulkReportException;
import com.software.tinyurl.bulk.model.exception.UnauthorizedBulkStatusException;
import com.software.tinyurl.bulk.model.request.BulkCreateRequest;
import com.software.tinyurl.bulk.model.request.BulkReportRequest;
import com.software.tinyurl.bulk.model.request.BulkStatusRequest;
import com.software.tinyurl.bulk.model.response.BulkReportResponse;
import com.software.tinyurl.bulk.model.response.BulkStatusResponse;
import com.software.tinyurl.core.model.exception.*;
import com.software.tinyurl.core.model.response.BulkCreateResponse;

public interface TinyUrlBulkAPI {

    public BulkCreateResponse bulk(BulkCreateRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedBulkCreateException, UnexpectedErrorException;

    public BulkStatusResponse bulkRequestStatus(BulkStatusRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedBulkStatusException, UnexpectedErrorException;

    public BulkReportResponse bulkReport(BulkReportRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedBulkReportException, UnexpectedErrorException;
}
