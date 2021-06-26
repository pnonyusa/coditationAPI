package com.pnonyusa.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String entity){
        super(entity);
    }
}
