package com.hiczp.bilibili.api.test;

import com.google.gson.GsonBuilder;
import com.hiczp.bilibili.api.BilibiliAPI;
import com.hiczp.bilibili.api.BilibiliSecurityHelper;
import com.hiczp.bilibili.api.passport.entity.LoginResponseEntity;

import java.util.Scanner;

public class ManualLoginTool {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input username and password");
        LoginResponseEntity loginResponseEntity = BilibiliSecurityHelper
                .login(new BilibiliAPI(), scanner.nextLine(), scanner.nextLine());

        new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(loginResponseEntity, System.out);
    }
}
