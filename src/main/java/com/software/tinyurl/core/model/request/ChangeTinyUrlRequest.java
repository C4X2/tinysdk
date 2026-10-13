package com.software.tinyurl.core.model.request;

import com.software.tinyurl.core.model.exception.RequiredFieldException;
import com.software.tinyurl.core.utils.MiscUtils;
import com.software.tinyurl.core.utils.TemplateLoader;
import com.software.tinyurl.core.validators.NonBlankStringValidator;

import java.util.Date;

import static com.software.tinyurl.core.utils.TemplateLoader.NO_TEMPLATE;

public class ChangeTinyUrlRequest implements TinyUrlRequest {
    private String url;

    private String domain;

    private String alias;

    private ChangeTinyUrlRequest(ChangeTinyUrlRequestBuilder builder)
    {
        this.url = builder.url;
        this.domain = builder.domain;
        this.alias = builder.alias;
    }

    public static ChangeTinyUrlRequestBuilder builder() {
        return new ChangeTinyUrlRequestBuilder();
    }

    @Override
    public String toJson() {
        String template = TemplateLoader.jsonTemplate("changeRequest.json");
        if (template == null || NO_TEMPLATE.equalsIgnoreCase(template)) return "{}";
        String jsonTemplate = template.replace("#{url}", MiscUtils.getOrDefault(this.url, ""))
                .replace("#{domain}", MiscUtils.getOrDefault(this.domain, ""))
                .replace("#{alias}", MiscUtils.getOrDefault(this.alias, ""));

        return jsonTemplate;
    }

    public static class ChangeTinyUrlRequestBuilder{
        private String url;

        private String domain;

        private String alias;


        public ChangeTinyUrlRequestBuilder url(String url)
        {
            this.url = url;
            return this;
        }

        public ChangeTinyUrlRequestBuilder domain(String domain)
        {
            this.domain = domain;
            return this;
        }

        public ChangeTinyUrlRequestBuilder alias(String alias)
        {
            this.alias = alias;
            return this;
        }

        public ChangeTinyUrlRequest build() throws RequiredFieldException {
            NonBlankStringValidator vz = new NonBlankStringValidator();
            vz.testThrow(this.url, new RequiredFieldException( "url", ChangeTinyUrlRequest.class));
            vz.testThrow(this.alias, new RequiredFieldException( "alias", ChangeTinyUrlRequest.class));
            vz.testThrow(this.domain, new RequiredFieldException( "domain", ChangeTinyUrlRequest.class));
            return new ChangeTinyUrlRequest(this);
        }
    }


}
