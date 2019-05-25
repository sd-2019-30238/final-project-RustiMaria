package com.project.cinemago.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cinema/register")
public class RegisterController {

    @RequestMapping(value = "")
    public String index(Model model){
        //model.addAttribute("title", "CinemaGO");
        return "cinema-go/register";
    }

}
