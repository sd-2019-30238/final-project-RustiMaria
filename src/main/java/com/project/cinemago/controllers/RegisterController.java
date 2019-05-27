package com.project.cinemago.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("cinema/register")
public class RegisterController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String displayRegisterForm(){
        return "cinema-go/register";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String getRegisterInfo(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String username, @RequestParam String password, @RequestParam String address, @RequestParam String email){
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(username);
        System.out.println(password);
        System.out.println(email);
        System.out.println(address);
        return "redirect:/cinema";
    }

}
