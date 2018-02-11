package com.hiczp.bilibili.api.test;

import com.google.gson.Gson;
import org.apache.log4j.BasicConfigurator;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        UserInfoTest.class,
        LiveClientTest.class,
        SsoTest.class,
        SendBulletScreenTest.class,
        SecurityHelperTest.class,
        AuthenticatorTest.class,
        LogoutTest.class
})
public class RuleSuite {
    @ClassRule
    public static ExternalResource externalResource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            init();
        }
    };

    public static void init() {
        //初始化 slf4j
        BasicConfigurator.configure();
        //读取配置文件
        try {
            Config.setConfig(
                    new Gson().fromJson(
                            new BufferedReader(new InputStreamReader(Config.class.getResourceAsStream("/config.json"))),
                            Config.class
                    )
            );
        } catch (NullPointerException e) {
            //抛出异常就可以取消测试
            throw new RuntimeException("Please create config file before tests");
        }
    }
}
