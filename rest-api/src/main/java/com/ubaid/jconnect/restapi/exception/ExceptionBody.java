package com.ubaid.jconnect.restapi.exception;

import lombok.Data;

@Data
public class ExceptionBody {
    private int status;
    private String message;
    private long timeStamp;

    public ExceptionBody(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}