package com.hiczp.bilibili.api.exception;

import java.io.IOException;

public class UserCancelRequestException extends IOException {
    public UserCancelRequestException() {

    }

    public UserCancelRequestException(String message) {
        super(message);
    }

    public UserCancelRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserCancelRequestException(Throwable cause) {
        super(cause);
    }
}
