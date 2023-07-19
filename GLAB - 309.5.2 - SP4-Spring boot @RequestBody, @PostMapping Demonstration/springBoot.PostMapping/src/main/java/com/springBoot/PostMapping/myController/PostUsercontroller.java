package com.springBoot.PostMapping.myController;

import com.springBoot.PostMapping.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*@RestController handles HTTP Requests and which marks the class as a controller
where every method returns an object instead of a view. It's the combo of @controller and @ResponseBody */
public class PostUsercontroller {
    @PostMapping("/users") //@PostMapping annotation ensures that HTTP POST Requests to “/users” are mapped to the printData() method.
    public void printData(@RequestBody User user){    //Spring @RequestBody, @ResponseBody are used to bind these HTTP request/responses body with objects.
        System.out.println("Printing the user data:"+user);
    }

}
