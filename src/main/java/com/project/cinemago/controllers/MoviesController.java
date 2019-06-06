package com.project.cinemago.controllers;

import com.project.cinemago.dao.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/cinema/movies")
public class MoviesController {

    @Autowired
    private MovieDAO movieDAO;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showMovies(Model model){

        model.addAttribute("movies", movieDAO.findAll());

        return "cinema-go/movies";

    }

}
