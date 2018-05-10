package com.hiczp.bilibili.api.passport.exception;

public class CaptchaMismatchException extends RuntimeException {
    public CaptchaMismatchException(String message) {
        super(message);
    }
}
