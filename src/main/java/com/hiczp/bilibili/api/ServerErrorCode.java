package com.hiczp.bilibili.api;

//不知道为什么错误码都要加负号
public class ServerErrorCode {
    public static class Passport {
        public static final int NO_LOGIN = -101;
        public static final int BAD_REQUEST = -400;
        //用户名不存在
        public static final int USERNAME_OR_PASSWORD_INVALID = -629;
        //密码不可解密或者密码错误
        public static final int CANT_DECRYPT_RSA_PASSWORD = -662;
        public static final int ACCESS_TOKEN_NOT_FOUND = -901;
        public static final int REFRESH_TOKEN_NOT_MATCH = -903;
    }

    public static class Live {
        //访问 isFollowed 时如果未登录, 返回的是 3, message 是 "user no login"
        public static final int USER_NO_LOGIN = 3;
        //正常的 API 如果未登录, 返回的是 -101
        public static final int NO_LOGIN = -101;
        public static final int BAD_REQUEST = -400;
        public static final int NOT_FOUND = -404;
        //弹幕长度超出限制时也是 -500
        public static final int INTERNAL_SERVER_ERROR = -500;
        //已经领取过这个宝箱
        public static final int THIS_SILVER_TASK_ALREADY_TOOK = -903;
        //今天所有的宝箱已经领完
        public static final int NO_MORE_SILVER_TASK = -10017;
    }
}
