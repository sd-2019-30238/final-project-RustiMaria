package com.project.cinemago.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("cinema/admin")
public class AdminController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showTasks(){
        return "cinema-go/admin";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String manageTasks(HttpServletRequest request){

        if(request.getParameter("add") != null){
            return "cinema-go/addMovie";
        }
        if(request.getParameter("update") != null){
            return "cinema-go/updateMovie";
        }
        if(request.getParameter("delete") != null){
            return "cinema-go/deleteMovie";
        }
        if(request.getParameter("reports") != null){
            return "redirect:/cinema/reports";
        }
        return "cinema-go/admin";
    }

}
