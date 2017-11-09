package com.hiczp.bilibili.api;

public class ServerErrorCode {
    public static class Passport {
        public static final int NO_LOGIN = -101;
        public static final int BAD_REQUEST = -400;
        public static final int USERNAME_OR_PASSWORD_INVALID = -629;
        public static final int CANT_DECRYPT_RSA_PASSWORD = -662;
        public static final int ACCESS_TOKEN_NOT_FOUND = -901;
        public static final int REFRESH_TOKEN_NOT_MATCH = -903;
    }
}
