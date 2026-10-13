package com.software.tinyurl.core.model.exception;

public class RequiredFieldException extends RuntimeException{
    public RequiredFieldException(String fieldName, Class z ){
        super("The field " + fieldName +" on class " + z.getName() + " is missing or null.");
    }

}
