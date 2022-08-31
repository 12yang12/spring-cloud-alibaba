package com.yang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yang.dao")
public class MybatisSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringBootApplication.class, args);
    }

}
