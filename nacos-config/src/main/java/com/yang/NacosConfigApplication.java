package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class NacosConfigApplication {

    public static void main(String[] args) throws InterruptedException {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigApplication.class, args);

        while (true) {
            // 当动态配置刷新时会更新到Enviroment中，因此这里每隔5秒中从Enviroment中获取配置
            String name = applicationContext.getEnvironment().getProperty("name");
            System.out.println("name: " + name);
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
