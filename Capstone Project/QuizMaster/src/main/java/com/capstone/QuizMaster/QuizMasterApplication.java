package com.capstone.QuizMaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.capstone.QuizMaster.controller" , "com.capstone.QuizMaster.model" ,
        "com.capstone.QuizMaster.myServices" , "com.capstone.QuizMaster.repository"})

public class QuizMasterApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuizMasterApplication.class, args);
    }

}
