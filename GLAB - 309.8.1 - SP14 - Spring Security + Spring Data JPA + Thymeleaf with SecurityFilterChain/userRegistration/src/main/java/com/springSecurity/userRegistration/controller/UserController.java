package com.springSecurity.userRegistration.controller;

import com.springSecurity.userRegistration.dto.UserDTO;
import com.springSecurity.userRegistration.myServices.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class UserController {
    //This controller is mapped to “/sign-up” URI.
    //using the UserDto to process and validate the user registration form and inject it using the @ModelAttribute("userDto") annotation.
    //When the form is submitted it’s automatically validated and errors are available in the BindingResult.
    // If the form has any errors, we return to the registration page.
    // Otherwise, we redirect and inform the user the registration procedure is complete

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    private UserServiceImpl userDetailsService;

    @Autowired
    private UserController(UserServiceImpl userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/")
    private String redirectToLogin()
    {
        return "redirect:/login";
    }


    @GetMapping("/sign-up")
    public String signUp(Model model){
        model.addAttribute("userDto", new UserDTO());
        return "sign-up";
    }

    @PostMapping("/signup-process")
    public String signupProcess(@Valid @ModelAttribute("userDto") UserDTO userDTO, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            log.warn("Wrong attempt");
            return "sign-up";
        }
        userDetailsService.create(userDTO);
        return "confirmation";
    }

    /**
     * In order to make code more readable it is good practice to
     * use special DTOs for login. It also make controllers
     * less dependent from entities and separate validation from
     * jpa functionality
     */

    @GetMapping("/login")
    public String getLoginPage(Model model)
    {
        log.info("Login page displayed");
        model.addAttribute("userDto", new UserDTO());
        return "login";
    }

    @PostMapping("/login-process")
    public String loginProcess(@Valid @ModelAttribute("userDto") UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.warn("Wrong attempt");
            return "login";
        }

        // Perform user authentication and validation logic here
        if (authenticateUser(userDTO.getUserName(), userDTO.getPassword())){
            // User authentication successful
            return "home"; // Redirect to the home page
        } else {
            // User authentication failed
            bindingResult.rejectValue("password", "error.userDTO", "Invalid username or password");
            log.warn("Failed login attempt");
            return "login"; // Return the login page with authentication error message
        }
    }

    private boolean authenticateUser(String userName, String password) {

        // Example: Check username and password against user records in the database
        UserDetails userDetails =  userDetailsService.loadUserByUsername(userName);
        log.info("User loaded by username");
        if(userDetails == null) {
            return false;
        }
        // Return true if authentication is successful, false otherwiseto
        //create a instance of BCryptencoder to initialize passwordEncoder and perfrom password validation
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, userDetails.getPassword());
    }


    @RequestMapping("/home")
    public String getHome()
    {
        log.info("home page displayed");
        return "home";
    }

}
