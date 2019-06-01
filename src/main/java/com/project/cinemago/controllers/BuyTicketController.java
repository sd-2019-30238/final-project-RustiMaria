package com.project.cinemago.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cinema/buy")
public class BuyTicketController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String buyTicketGet(){
        return "cinema-go/buy";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String buyTicketPost(@RequestParam("movieId") int movieId){

        Model model = null;
        System.out.println(movieId);
        model.addAttribute("id", movieId);

        return "cinema-go/buy";
    }

}