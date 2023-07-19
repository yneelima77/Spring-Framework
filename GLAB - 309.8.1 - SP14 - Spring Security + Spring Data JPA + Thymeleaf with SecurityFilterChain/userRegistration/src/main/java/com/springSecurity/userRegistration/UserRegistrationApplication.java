package com.springSecurity.userRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springSecurity.userRegistration.config", "com.springSecurity.userRegistration.controller",
        "com.springSecurity.userRegistration.dto","com.springSecurity.userRegistration.model", "com.springSecurity.userRegistration.myServices",
        "com.springSecurity.userRegistration.repository", "com.springSecurity.userRegistration.constraints"})
public class UserRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRegistrationApplication.class, args);
    }

}
