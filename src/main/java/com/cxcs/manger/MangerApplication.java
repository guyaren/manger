package com.cxcs.manger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cxcs.manger.dao")
public class MangerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangerApplication.class, args);
    }

}
