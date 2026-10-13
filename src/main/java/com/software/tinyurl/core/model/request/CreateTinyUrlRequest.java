package com.software.tinyurl.core.model.request;

import com.software.tinyurl.core.model.exception.RequiredFieldException;
import com.software.tinyurl.core.utils.MiscUtils;
import com.software.tinyurl.core.utils.TemplateLoader;
import com.software.tinyurl.core.validators.NonBlankStringValidator;

import java.util.Date;

import static com.software.tinyurl.core.utils.TemplateLoader.NO_TEMPLATE;

public class CreateTinyUrlRequest implements TinyUrlRequest {

    private String url;

    private String domain;

    private String alias;

    private String tags;

    private Date expiresAt;

    private String description;

    private CreateTinyUrlRequest(CreateTinyUrlRequestBuilder builder)
    {
        this.url = builder.url;
        this.domain = builder.domain;
        this.alias = builder.alias;
        this.tags = builder.tags;
        this.expiresAt = builder.expiresAt;
        this.description = builder.description;
    }

    public static CreateTinyUrlRequestBuilder builder() {
        return new CreateTinyUrlRequestBuilder();
    }

    @Override
    public String toJson() {
        String template = TemplateLoader.jsonTemplate("createRequest.json");
        if (template == null || NO_TEMPLATE.equalsIgnoreCase(template)) return "{}";
        String dateString = MiscUtils.safeToString(this.expiresAt, "");
        String jsonTemplate = template.replace("#{url}", MiscUtils.getOrDefault(this.url, ""))
                .replace("#{domain}", MiscUtils.getOrDefault(this.domain, ""))
                .replace("#{alias}", MiscUtils.getOrDefault(this.alias, ""))
                .replace("#{tags}", MiscUtils.getOrDefault(this.tags, ""))
                .replace("#{expiresAt}", dateString)
                .replace("#{description}", MiscUtils.getOrDefault(this.description, ""));

        return jsonTemplate;
    }

    public static class CreateTinyUrlRequestBuilder{
        private String url;

        private String domain;

        private String alias;

        private String tags;

        private Date expiresAt;

        private String description;

        public CreateTinyUrlRequestBuilder url(String url)
        {
            this.url = url;
            return this;
        }

        public CreateTinyUrlRequestBuilder domain(String domain)
        {
            this.domain = domain;
            return this;
        }

        public CreateTinyUrlRequestBuilder alias(String alias)
        {
            this.alias = alias;
            return this;
        }

        public CreateTinyUrlRequestBuilder tags(String tags)
        {
            this.tags = tags;
            return this;
        }

        public CreateTinyUrlRequestBuilder expiresAt(Date expiresAt)
        {
            this.expiresAt = expiresAt;
            return this;
        }

        public CreateTinyUrlRequestBuilder description(String description)
        {
            this.description = description;
            return this;
        }

        public CreateTinyUrlRequest build() throws RequiredFieldException {
            NonBlankStringValidator vz = new NonBlankStringValidator();
            vz.testThrow(this.url, new RequiredFieldException( "url", CreateTinyUrlRequest.class));
            return new CreateTinyUrlRequest(this);
        }
    }


}
