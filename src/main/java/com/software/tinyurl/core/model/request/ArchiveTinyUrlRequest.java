package com.software.tinyurl.core.model.request;

import com.software.tinyurl.core.model.exception.RequiredFieldException;
import com.software.tinyurl.core.utils.MiscUtils;
import com.software.tinyurl.core.utils.TemplateLoader;
import com.software.tinyurl.core.validators.NonBlankStringValidator;

import static com.software.tinyurl.core.utils.TemplateLoader.NO_TEMPLATE;

public class ArchiveTinyUrlRequest implements TinyUrlRequest {

    private String domain;

    private String alias;

    private ArchiveTinyUrlRequest(ArchiveTinyUrlRequestBuilder builder)
    {
        this.domain = builder.domain;
        this.alias = builder.alias;
    }

    public static ArchiveTinyUrlRequestBuilder builder() {
        return new ArchiveTinyUrlRequestBuilder();
    }

    @Override
    public String toJson() {
        String template = TemplateLoader.jsonTemplate("archiveRequest.json");
        if (template == null || NO_TEMPLATE.equalsIgnoreCase(template)) return "{}";
        String jsonTemplate = template
                .replace("#{domain}", MiscUtils.getOrDefault(this.domain, ""))
                .replace("#{alias}", MiscUtils.getOrDefault(this.alias, ""));

        return jsonTemplate;
    }

    public static class ArchiveTinyUrlRequestBuilder{

        private String domain;

        private String alias;



        public ArchiveTinyUrlRequestBuilder domain(String domain)
        {
            this.domain = domain;
            return this;
        }

        public ArchiveTinyUrlRequestBuilder alias(String alias)
        {
            this.alias = alias;
            return this;
        }

        public ArchiveTinyUrlRequest build() throws RequiredFieldException {
            NonBlankStringValidator vz = new NonBlankStringValidator();
            vz.testThrow(this.alias, new RequiredFieldException( "alias", ChangeTinyUrlRequest.class));
            vz.testThrow(this.domain, new RequiredFieldException( "domain", ChangeTinyUrlRequest.class));
            return new ArchiveTinyUrlRequest(this);
        }
    }

}
