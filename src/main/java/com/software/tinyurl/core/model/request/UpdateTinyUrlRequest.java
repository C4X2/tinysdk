package com.software.tinyurl.core.model.request;

import com.software.tinyurl.core.model.exception.RequiredFieldException;
import com.software.tinyurl.core.utils.MiscUtils;
import com.software.tinyurl.core.utils.TemplateLoader;
import com.software.tinyurl.core.validators.NonBlankStringValidator;

import java.util.Date;

import static com.software.tinyurl.core.utils.TemplateLoader.NO_TEMPLATE;

public class UpdateTinyUrlRequest implements TinyUrlRequest {

    private String domain;

    private String newDomain;

    private String alias;

    private String newAlias;

    private String newTags;

    private boolean newStats;

    private Date newExpiresAt;

    private String newDescription;

    private UpdateTinyUrlRequest(UpdateTinyUrlRequestBuilder bldr) {
        this.domain = bldr.domain;
        this.newDomain = bldr.newDomain;
        this.alias = bldr.alias;
        this.newAlias = bldr.newAlias;
        this.newTags = bldr.newTags;
        this.newStats = bldr.newStats;
        this.newExpiresAt = bldr.newExpiresAt;
        this.newDescription = bldr.newDescription;
    }
    public static UpdateTinyUrlRequestBuilder builder() {
        return new UpdateTinyUrlRequestBuilder();
    }

    @Override
    public String toJson() {
        String template = TemplateLoader.jsonTemplate("updateRequest.json");
        if (template == null || NO_TEMPLATE.equalsIgnoreCase(template)) return "{}";
        String dateString = MiscUtils.safeToString(this.newExpiresAt, "");
        String jsonTemplate = template.replace("#{new_stats}", String.valueOf(this.newStats))
                .replace("#{domain}", MiscUtils.getOrDefault(this.domain, ""))
                .replace("#{alias}", MiscUtils.getOrDefault(this.alias, ""))
                .replace("#{new_domain}", MiscUtils.getOrDefault(this.newDomain, ""))
                .replace("#{new_alias}", MiscUtils.getOrDefault(this.newAlias, ""))
                .replace("#{tags}", buildNewTagsList())
                .replace("#{new_expires_at}", dateString)
                .replace("#{new_description}", MiscUtils.getOrDefault(this.newDescription, ""));

        return jsonTemplate;
    }

    private String buildNewTagsList() {
        //TODO
        return null;
    }


    public String getDomain() {
        return domain;
    }

    public String getNewDomain() {
        return newDomain;
    }

    public String getAlias() {
        return alias;
    }

    public String getNewAlias() {
        return newAlias;
    }

    public String getNewTags() {
        return newTags;
    }

    public boolean isNewStats() {
        return newStats;
    }

    public Date getNewExpiresAt() {
        return newExpiresAt;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public static class UpdateTinyUrlRequestBuilder {

        private String domain;

        private String newDomain;

        private String alias;

        private String newAlias;

        private String newTags;

        private boolean newStats;

        private Date newExpiresAt;

        private String newDescription;

        public UpdateTinyUrlRequestBuilder newDomain(String newDomain)
        {
            this.newDomain = newDomain;
            return this;
        }

        public UpdateTinyUrlRequestBuilder domain(String domain)
        {
            this.domain = domain;
            return this;
        }

        public UpdateTinyUrlRequestBuilder alias(String alias)
        {
            this.alias = alias;
            return this;
        }

        public UpdateTinyUrlRequestBuilder newAlias(String newAlias)
        {
            this.newAlias = newAlias;
            return this;
        }

        public UpdateTinyUrlRequestBuilder tags(String tags)
        {
            this.newTags = tags;
            return this;
        }

        public UpdateTinyUrlRequestBuilder newExpiresAt(Date newExpiresAt)
        {
            this.newExpiresAt = newExpiresAt;
            return this;
        }

        public UpdateTinyUrlRequestBuilder expiresAt(boolean newStats)
        {
            this.newStats = newStats;
            return this;
        }

        public UpdateTinyUrlRequestBuilder newDescription(String newDescription)
        {
            this.newDescription = newDescription;
            return this;
        }

        public UpdateTinyUrlRequest build() throws RequiredFieldException {
            NonBlankStringValidator vz = new NonBlankStringValidator();
            vz.testThrow(this.domain, new RequiredFieldException( "domain", CreateTinyUrlRequest.class));
            vz.testThrow(this.alias, new RequiredFieldException( "alias", CreateTinyUrlRequest.class));
            return new UpdateTinyUrlRequest(this);
        }

    }
}
