package com.gosang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gosang.mapper")
public class MangerCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangerCourseApplication.class, args);
    }

}
