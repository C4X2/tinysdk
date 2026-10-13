package com.software.tinyurl.core.model.request;

import com.software.tinyurl.core.model.exception.RequiredFieldException;
import com.software.tinyurl.core.validators.NonBlankStringValidator;

public class DomainAliasTinyUrlRequest{

    private String alias;

    private String domain;

    private DomainAliasTinyUrlRequest(String alias, String domain){
        this.alias = alias;
        this.domain = domain;
    }

    private DomainAliasTinyUrlRequest(DomainAliasTinyUrlRequestBuilder rqb){
        this.alias = rqb.alias;
        this.domain = rqb.domain;
    }

    public static DomainAliasTinyUrlRequestBuilder builder(){
        return new DomainAliasTinyUrlRequestBuilder();
    }

    public String getAlias() {
        return this.alias;
    }

    public String getDomain() {
        return this.domain;
    }

    public static class DomainAliasTinyUrlRequestBuilder {
        private String alias;

        private String domain;

        private DomainAliasTinyUrlRequestBuilder(){

        }

        public DomainAliasTinyUrlRequestBuilder alias(String alias){
            this.alias = alias;
            return this;
        }

        public DomainAliasTinyUrlRequestBuilder domain(String domain){
            this.domain = domain;
            return this;
        }

        public DomainAliasTinyUrlRequest build() throws RequiredFieldException {
            NonBlankStringValidator vz = new NonBlankStringValidator();
            vz.testThrow(this.domain, new RequiredFieldException( "domain", CreateTinyUrlRequest.class));
            vz.testThrow(this.alias, new RequiredFieldException( "alias", CreateTinyUrlRequest.class));
            return new DomainAliasTinyUrlRequest(this);
        }
    }
}
