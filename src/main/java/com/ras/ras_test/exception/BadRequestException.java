package com.ras.ras_test.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message){
        super(message);
    }
}
