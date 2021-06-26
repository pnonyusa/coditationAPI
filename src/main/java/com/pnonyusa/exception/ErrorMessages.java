package com.pnonyusa.exception;

import lombok.Getter;



@Getter
public enum ErrorMessages {

    MISSING_REQUIRED_FIELD("Missing required field.please check the documentation for required field"),
    RECORD_ALREADY_EXISTS("Record already exists."),
    INTERNAL_SERVER_ERROR("internal server error."),
    NO_RECORD_FOUND("record with provided id is not found."),
    OBJECT_IS_NULL("Object is null");
    private String errorMessages;

    ErrorMessages(String errorMessages){
        this.errorMessages=errorMessages;
    }

    public void setErrorMessages(String errorMessages) {
        this.errorMessages = errorMessages;
    }
}
