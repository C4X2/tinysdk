package com.software.tinyurl.core.services;

import com.software.tinyurl.core.model.exception.*;
import com.software.tinyurl.core.model.request.AnonymousCreateTinyUrlRequest;
import com.software.tinyurl.core.model.request.CreateTinyUrlRequest;
import com.software.tinyurl.core.model.response.AnonymousCreateTinyUrlResponse;

public interface AnonymousTinyUrlAPI {

    public AnonymousCreateTinyUrlResponse create(AnonymousCreateTinyUrlRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnonymousCreateException, UnexpectedErrorException;

}
