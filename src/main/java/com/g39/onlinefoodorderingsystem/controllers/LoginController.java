package com.g39.onlinefoodorderingsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.g39.onlinefoodorderingsystem.security.User;
import com.g39.onlinefoodorderingsystem.services.UserService;

@Controller
public class LoginController {
	@Autowired
    private UserService userService;
	
	@ModelAttribute(name="user")
	public User user() {
		return new User();
	}
	
	@GetMapping("/login")
    public String login(){
        return "login";
    }
	@GetMapping("/register")
	public String registration() {
		return "register";
	}
	 @PostMapping("/register")
	    public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
	        User userExists = userService.findUserByUsername(user.getUsername());
	        if (userExists != null) {
	            bindingResult
	                    .rejectValue("username", "error.username",
	                            "There is already a user registered with the username provided");
	        }
	        if (bindingResult.hasErrors()) {
	            return "register";
	        } else {
	        	
	            userService.saveUser(user);
	            
	            model.addAttribute("successMessage", "User has been registered successfully");
	            
	            return "login";
	        }
	    }
	@GetMapping("/access-denied")
    public String accessDenied(){
        return "access_denied";
    }
}
