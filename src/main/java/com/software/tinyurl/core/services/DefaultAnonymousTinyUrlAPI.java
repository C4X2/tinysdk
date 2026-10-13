package com.software.tinyurl.core.services;

import com.software.tinyurl.core.model.exception.ImproperRequestException;
import com.software.tinyurl.core.model.exception.PermissionDeniedException;
import com.software.tinyurl.core.model.exception.UnauthorizedAnonymousCreateException;
import com.software.tinyurl.core.model.exception.UnexpectedErrorException;
import com.software.tinyurl.core.model.request.AnonymousCreateTinyUrlRequest;
import com.software.tinyurl.core.model.response.AnonymousCreateTinyUrlResponse;

public class DefaultAnonymousTinyUrlAPI implements AnonymousTinyUrlAPI{
    @Override
    public AnonymousCreateTinyUrlResponse create(AnonymousCreateTinyUrlRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnonymousCreateException, UnexpectedErrorException {
        //TODO
        return null;
    }
}
