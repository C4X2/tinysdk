package com.software.tinyurl.core.validators;

import com.software.tinyurl.core.model.exception.RequiredFieldException;

public class NonBlankStringValidator implements TinyUrlValidation<String, RequiredFieldException> {
    @Override
    public boolean testThrow(String s, RequiredFieldException e) throws RequiredFieldException {
        if (test(s)) return true;
        throw e;
    }

    @Override
    public boolean test(String s) {
        return (s != null && !s.isBlank());
    }
}
