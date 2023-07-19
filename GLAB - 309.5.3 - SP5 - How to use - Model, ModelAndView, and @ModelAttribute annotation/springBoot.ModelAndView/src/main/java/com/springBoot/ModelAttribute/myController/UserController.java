package com.springBoot.ModelAttribute.myController;

import com.springBoot.ModelAttribute.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    /*This method demonstrates the use @ModelAttribute annotation at the method level.
     * This method creates a list and returns a list of countries
     * @return list of countries
     */
    @ModelAttribute("countries")
    public List<String> getUserCountries(){
        List<String> countries =  new ArrayList<>();
        countries.add("UK");
        countries.add("USA");
        countries.add("UAE");
        countries.add("Japan");
        return countries;
    }

    /* This method is the variation of the above method. It will accept a model and save values in this model.
    These saved values will be available on the frontend to the custom  */
    @ModelAttribute
    public void getUsers(Model model){
        User u1 = new User(1, "Hasib", "haseeb@abc.com,");
        User u2 = new User(2, "Saharan", "Shahparan@abc.com,");
        User u3 = new User(3, "James", "James@abc.com,");
        User u4 = new User(4, "Joseph", "Joseph@abc.com,");

        List<User> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        model.addAttribute("userlist", userList);
    }

    /* A handler method can have more than-one parameters with @ModelAttribute
     * The following handler method will retrieve the 'countries'  *    *attribute from the model
     */
    @GetMapping("/Home")
    public String home(@ModelAttribute("countries") List<String> countries, Model model){
        //Adding more countries
        countries.add("Australia");
        countries.add("Canada");
        return "Home";
    }

}
