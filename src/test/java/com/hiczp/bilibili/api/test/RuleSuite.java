package com.hiczp.bilibili.api.test;

import com.google.gson.Gson;
import org.apache.log4j.BasicConfigurator;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserInfoTest.class,
        LiveClientTest.class,
        SsoTest.class,
        SendBulletScreenTest.class
})
public class RuleSuite {
    @ClassRule
    public static ExternalResource externalResource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
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

            Config config = Config.getInstance();
            //登录
            Config.getBilibiliAPI().login(config.getUsername(), config.getPassword());
        }

        @Override
        protected void after() {
            try {
                Config.getBilibiliAPI().logout();
            } catch (IOException | LoginException e) {
                e.printStackTrace();
            }
        }
    };
}
