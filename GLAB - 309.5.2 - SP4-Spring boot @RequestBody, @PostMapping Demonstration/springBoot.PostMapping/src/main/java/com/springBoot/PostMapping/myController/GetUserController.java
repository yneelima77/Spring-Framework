package com.springBoot.PostMapping.myController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetUserController {
    @GetMapping("/users")
    public String getUser(){
        return "userData.html";
    }
}
