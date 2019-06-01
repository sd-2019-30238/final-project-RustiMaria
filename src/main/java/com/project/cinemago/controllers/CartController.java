package com.project.cinemago.controllers;

import com.project.cinemago.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cinema/cart")
public class CartController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getMethod(HttpSession session){
        User user = (User)session.getAttribute("user-entity");
        if(user == null){
            return "cinema-go/loginNeeded";
        }
        return "cinema-go/cart";
    }

}
