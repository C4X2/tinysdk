package com.software.tinyurl.analytics.services;

import com.software.tinyurl.analytics.model.exception.*;
import com.software.tinyurl.analytics.model.request.*;
import com.software.tinyurl.analytics.model.response.*;
import com.software.tinyurl.core.model.exception.ImproperRequestException;
import com.software.tinyurl.core.model.exception.PermissionDeniedException;
import com.software.tinyurl.core.model.exception.UnexpectedErrorException;

public interface TinyUrlAnalyticsAPI {

    public AnalyticsStatusResponse analyticStatus(AnalyticsStatusRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsStatusException, UnexpectedErrorException;

    public AnalyticsSharingResponse analyticSharing(AnalyticsSharingRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsSharingException, UnexpectedErrorException;

    public AnalyticsRawResponse analyticRawJson(AnalyticsRawRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsRawException, UnexpectedErrorException;

    public AnalyticsTimelineResponse analyticTimeline(AnalyticsTimelineRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsTimelineException, UnexpectedErrorException;

    public AnalyticsGeneralResponse analyticGeneral(AnalyticsGeneralRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsGeneralException, UnexpectedErrorException;

    public AnalyticsWeekdayPopularityResponse analyticPopularityByWeekday(AnalyticsWeekdayPopularityRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsWeekdayPopularityException, UnexpectedErrorException;

    public AnalyticsHourlyPopularityResponse analyticPopularityByHour(AnalyticsHourlyPopularityRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsHourlyPopularityException, UnexpectedErrorException;

    public AnalyticsTopSourceResponse analyticTopSource(AnalyticsTopSourceRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsTopSourceException, UnexpectedErrorException;

    public AnalyticsTopLanguagesResponse analyticTopLanguages(AnalyticsTopLanguagesRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsTopLanguagesException, UnexpectedErrorException;

    public AnalyticsLocaleResponse analyticLocale(AnalyticsLocaleRequest request) throws ImproperRequestException, PermissionDeniedException, UnauthorizedAnalyticsLocaleException, UnexpectedErrorException;

}
