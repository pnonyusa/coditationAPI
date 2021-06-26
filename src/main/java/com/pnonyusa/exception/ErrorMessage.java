package com.pnonyusa.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class ErrorMessage {

    private Date timeStamp;
    private String message;

    public  ErrorMessage(Date timeStamp,String message){
        this.timeStamp=timeStamp;
        this.message=message;
    }
}
