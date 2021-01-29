package com.babygu.flight.flightreservation.controllers;


import com.babygu.flight.flightreservation.entities.User;
import com.babygu.flight.flightreservation.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/showReg")
    public String showRegistrationPage(){
        return "registerUser";
    }

    @RequestMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user){
        userRepository.save(user);
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("email")String email, @RequestParam("password")String password, ModelMap map){
        User user = userRepository.findByEmail(email);
        if(user.getPassword().equals(password)){
            return "findflight";
        }else{
            map.addAttribute("msg","invalid username or password");
        }
        return "login";
    }
}
