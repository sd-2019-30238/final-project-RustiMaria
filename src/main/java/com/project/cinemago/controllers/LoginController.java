package com.project.cinemago.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("cinema/login")
public class LoginController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String displayLoginForm(){
        return "cinema-go/login";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String getLoginInfo(@RequestParam String username, @RequestParam String password){
        System.out.println(username);
        System.out.println(password);
        return "redirect:/cinema";
    }

}
