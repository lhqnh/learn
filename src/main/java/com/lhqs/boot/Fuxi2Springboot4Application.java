package com.lhqs.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lhqs.boot.mapper")
public class Fuxi2Springboot4Application {

    public static void main(String[] args) {
        SpringApplication.run(Fuxi2Springboot4Application.class, args);
    }

}
