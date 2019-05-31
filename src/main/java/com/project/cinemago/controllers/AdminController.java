package com.project.cinemago.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "cinema/admin")
public class AdminController {

    @RequestMapping(value = "cinema/admin", method = RequestMethod.GET)
    public String showTasks(){
        return "cinema-go/admin";
    }

    @RequestMapping(value = "cinema/admin", method = RequestMethod.POST)
    public String manageTasks(@RequestParam String add, @RequestParam String delete, @RequestParam String update, @RequestParam String reports){

        if(!add.isEmpty()){
            return "cinema-go/addMovie";
        }
        if(!update.isEmpty()){
            return "cinema-go/updateMovie";
        }
        if(!delete.isEmpty()){
            return "cinema-go/deleteMovie";
        }
        if(!reports.isEmpty()){
            return "cinema-go/reports";
        }
        return "cinema-go/admin";
    }

}
