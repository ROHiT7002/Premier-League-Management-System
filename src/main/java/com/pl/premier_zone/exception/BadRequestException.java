package com.pl.premier_zone.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message)
    {
        super(message);
    }
}
