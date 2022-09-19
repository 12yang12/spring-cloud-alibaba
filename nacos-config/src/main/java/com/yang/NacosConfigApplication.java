package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NacosConfigApplication {

    public static void main(String[] args) throws InterruptedException {
       SpringApplication.run(NacosConfigApplication.class, args);
        // ConfigurableApplicationContext applicationContext =
        // while (true) {
        //     //当动态配置刷新时，会更新到 Enviroment中，因此这里每隔一秒中从Enviroment中获取配置
        //     String name = applicationContext.getEnvironment().getProperty("name");
        //     System.err.println("name :" + name );
        //     TimeUnit.SECONDS.sleep(1);
        // }
    }
}
