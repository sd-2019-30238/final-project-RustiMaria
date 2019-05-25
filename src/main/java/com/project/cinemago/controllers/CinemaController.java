package com.project.cinemago.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cinema")
public class CinemaController {

    @RequestMapping(value = "")
    public String index(Model model){
        //model.addAttribute("title", "CinemaGO");
        return "cinema-go/menu";
    }

}
