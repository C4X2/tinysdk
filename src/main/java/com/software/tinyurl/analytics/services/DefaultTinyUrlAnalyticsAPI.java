package com.software.tinyurl.analytics.services;

import com.software.tinyurl.analytics.model.exception.*;
import com.software.tinyurl.analytics.model.request.*;
import com.software.tinyurl.analytics.model.response.*;
import com.software.tinyurl.core.model.exception.ImproperRequestException;
import com.software.tinyurl.core.model.exception.PermissionDeniedException;
import com.software.tinyurl.core.model.exception.UnexpectedErrorException;

public class DefaultTinyUrlAnalyticsAPI implements TinyUrlAnalyticsAPI{
    @Override
    public AnalyticsStatusResponse analyticStatus(AnalyticsStatusRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsStatusException, UnexpectedErrorException {
        return null;
    }

    @Override
    public AnalyticsSharingResponse analyticSharing(AnalyticsSharingRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsSharingException, UnexpectedErrorException {
        return null;
    }

    @Override
    public AnalyticsRawResponse analyticRawJson(AnalyticsRawRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsRawException, UnexpectedErrorException {
        return null;
    }

    @Override
    public AnalyticsTimelineResponse analyticTimeline(AnalyticsTimelineRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsTimelineException, UnexpectedErrorException {
        return null;
    }

    @Override
    public AnalyticsGeneralResponse analyticGeneral(AnalyticsGeneralRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsGeneralException, UnexpectedErrorException {
        return null;
    }

    @Override
    public AnalyticsWeekdayPopularityResponse analyticPopularityByWeekday(AnalyticsWeekdayPopularityRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsWeekdayPopularityException, UnexpectedErrorException {
        return null;
    }

    @Override
    public AnalyticsHourlyPopularityResponse analyticPopularityByHour(AnalyticsHourlyPopularityRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsHourlyPopularityException, UnexpectedErrorException {
        return null;
    }

    @Override
    public AnalyticsTopSourceResponse analyticTopSource(AnalyticsTopSourceRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsTopSourceException, UnexpectedErrorException {
        return null;
    }

    @Override
    public AnalyticsTopLanguagesResponse analyticTopLanguages(AnalyticsTopLanguagesRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsTopLanguagesException, UnexpectedErrorException {
        return null;
    }

    @Override
    public AnalyticsLocaleResponse analyticLocale(AnalyticsLocaleRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsLocaleException, UnexpectedErrorException {
        return null;
    }
}
