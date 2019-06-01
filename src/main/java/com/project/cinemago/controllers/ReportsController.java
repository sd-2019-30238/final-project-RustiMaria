package com.project.cinemago.controllers;

import com.project.cinemago.dao.MovieDAO;
import com.project.cinemago.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cinema/reports")
public class ReportsController {

    @Autowired
    private MovieDAO movieDAO;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getMethod(Model model){
        String message = "";
        long moviesNo = movieDAO.count();
        message += "There are " + moviesNo + " movies available!";
        model.addAttribute("message", message);
        return "cinema-go/reports";
    }

}
