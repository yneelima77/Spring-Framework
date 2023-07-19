package com.springBoot.SessionAndModelAttribute.myController;

import com.springBoot.SessionAndModelAttribute.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("u")
public class Session_Controller {

    /*
     * Add user in model attribute
     */
    @ModelAttribute("u")
    public User setUpUserForm() {
        return new User();
    }

    @GetMapping("/dologin")
    public String doLogin(@ModelAttribute("u") User u, Model model) {
        model.addAttribute("FormVar", u);
        return "UserForm";
        // We will create UserForm.html page in next step
    }

    @PostMapping("/Getuser")
    public String userInfo(@ModelAttribute("u") User user, Model model) {
        System.out.println("Email: " + user.getEmail());
        System.out.println("First Name: " + user.getName());
        System.out.println("Id: " + user.getId());
        model.addAttribute("stu",user);
        return "showData";
        // We will create showData.html page in next step
    }

}
