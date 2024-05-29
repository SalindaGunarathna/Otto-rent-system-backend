package com.cttorentsystem.ottorentbackend.exception;



public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
