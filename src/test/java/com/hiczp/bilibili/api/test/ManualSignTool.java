package com.hiczp.bilibili.api.test;

import com.hiczp.bilibili.api.BilibiliClientProperties;
import com.hiczp.bilibili.api.BilibiliSecurityHelper;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//Insomnia 手动测试时使用
//拷贝入整个 url, 它将自动计算出 sign
public class ManualSignTool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input url");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("q")) {
                break;
            }
            if (input.isEmpty()) {
                continue;
            }

            int index = input.indexOf("?");
            if (index == -1) {
                continue;
            }

            List<String> nameAndValues = Arrays.stream(input.substring(index + 1)
                    .split("&"))
                    .filter(param -> !param.startsWith("sign="))
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println(
                    BilibiliSecurityHelper.calculateSign(nameAndValues, BilibiliClientProperties.defaultSetting().getAppSecret())
            );
        }
    }
}
