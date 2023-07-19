package com.springBoot.ModelAttribute.myController;

import com.springBoot.ModelAttribute.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ModelAndViewcontroller {

    @GetMapping("/showViewPage")
    public String passParametersWithModel(Model model) {
        model.addAttribute("message", "PerScholas");
        model.addAttribute("WelcomeMessage", "welcome");
        int i = 10;
        model.addAttribute("number", i);

        List<String> list = Arrays.asList("One", "Two");
        model.addAttribute("listData", list);
        return "viewPage";
    }

    @GetMapping("/gotoViewPage")
    public ModelAndView passParametersWithModelAndView() {
        String st = "Welcome to the Page";
        ModelAndView modelAndView = new ModelAndView("viewPage_2");
        modelAndView.addObject("message", st);
        modelAndView.addObject("info", "Employee Information");
        return modelAndView;
    }

    @GetMapping("/gotoUserViewPage")
    public ModelAndView UserModelAndView() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Hasib", "haseeb@abc.com,"));
        userList.add(new User(2, "Saharan", "Shahparan@abc.com,"));
        userList.add(new User(3, "James", "James@abc.com,"));
        userList.add(new User(4, "Joseph", "Joseph@abc.com,"));

        ModelAndView modelAndView = new ModelAndView("userdata");
        modelAndView.addObject("userlist", userList);
        return modelAndView;
    }

}
