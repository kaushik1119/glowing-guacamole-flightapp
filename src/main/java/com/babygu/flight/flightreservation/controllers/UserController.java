package com.babygu.flight.flightreservation.controllers;


import com.babygu.flight.flightreservation.entities.User;
import com.babygu.flight.flightreservation.repos.UserRepository;
import com.babygu.flight.flightreservation.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private SecurityService securityService;

    @RequestMapping("/showReg")
    public String showRegistrationPage(){
        return "registerUser";
    }

    @RequestMapping(value = "/showLogin")
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return showLoginPage();
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("email")String email, @RequestParam("password")String password, ModelMap map){
        boolean loginResult = securityService.login(email, password);
        if(loginResult){
            return new ModelAndView("redirect:/findFlight");
        }else{
            map.addAttribute("msg","invalid username or password");
        }
        return new ModelAndView("showLogin");
    }
}
