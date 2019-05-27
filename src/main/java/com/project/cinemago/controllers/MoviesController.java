package com.project.cinemago.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/cinema/movies")
public class MoviesController {

    List<String> strings = new ArrayList<String>();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showMovies(Model model){

        strings.add("M1");
        strings.add("M2");

        model.addAttribute("strings", strings);

        return "cinema-go/movies";

    }

}
