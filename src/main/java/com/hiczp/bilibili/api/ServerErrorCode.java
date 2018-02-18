package com.hiczp.bilibili.api;

//不知道为什么错误码都要加负号
public class ServerErrorCode {
    //服务网关上鉴权失败的话, 会返回这些标准错误码
    //B站后台设计很混乱, 不是所有鉴权都在服务网关上完成
    public static class Common {
        public static final int OK = 0;
        public static final int BAD_REQUEST = -400;
        public static final int UNAUTHORIZED = -401;
        public static final int FORBIDDEN = -403;
        public static final int NOT_FOUND = -404;
        public static final int INTERNAL_SERVER_ERROR = -500;
    }

    //现在 access token 错误统一返回 -101
    public static class Passport {
        //"access_key not found"
        public static final int NO_LOGIN = -101;
        //短时间内进行多次错误的登录将被要求输入验证码
        public static final int CAPTCHA_NOT_MATCH = -105;
        //用户名不存在
        public static final int USERNAME_OR_PASSWORD_INVALID = -629;
        //密码不可解密或者密码错误
        public static final int CANT_DECRYPT_RSA_PASSWORD = -662;
        @Deprecated
        public static final int ACCESS_TOKEN_NOT_FOUND = -901;  //B站换了错误码, 现在 "access_key not found." 对应 -101
        public static final int REFRESH_TOKEN_NOT_MATCH = -903;
    }

    //一些 API 未登录时返回 3, 一些返回 -101, 还有一些返回 401, 在网关上鉴权的 API 返回 -401
    //甚至有一些 API 返回 32205 这种奇怪的错误码
    public static class Live {
        //"user no login"
        public static final int USER_NO_LOGIN = 3;
        //"请登录"
        public static final int PLEASE_LOGIN = 401;
        //"请登录"
        public static final int PLEASE_LOGIN0 = 32205;
        //"请先登录"
        public static final int NO_LOGIN = -101;
        //"关键字不能小于2个字节或大于50字节"
        public static final int KEYWORD_CAN_NOT_LESS_THAN_2_BYTES_OR_GREATER_THAN_50_BYTES = -609;
        //已经领取过这个宝箱
        public static final int THIS_SILVER_TASK_ALREADY_TOOK = -903;
        //今天所有的宝箱已经领完
        public static final int NO_MORE_SILVER_TASK = -10017;
    }
}
