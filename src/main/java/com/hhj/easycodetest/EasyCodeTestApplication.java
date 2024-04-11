package com.hhj.easycodetest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hhj.easycodetest.dao")
public class EasyCodeTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyCodeTestApplication.class, args);
    }

}
