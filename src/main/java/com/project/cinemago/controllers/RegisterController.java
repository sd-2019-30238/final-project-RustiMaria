package com.project.cinemago.controllers;

import com.project.cinemago.dao.UserDAO;
import com.project.cinemago.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("cinema/register")
public class RegisterController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String displayRegisterForm(){
        return "cinema-go/register";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String getRegisterInfo(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String username, @RequestParam String password, @RequestParam String address, @RequestParam String email){
        User user = new User(firstName, lastName, username, password, email, address);
        userDAO.save(user);
        return "cinema-go/registerSuccess";
    }

}
