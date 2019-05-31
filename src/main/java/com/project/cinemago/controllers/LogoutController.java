package com.project.cinemago.controllers;

import com.project.cinemago.models.User;
import com.project.cinemago.AppUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("cinema/logout")
public class LogoutController {

    //@RequestMapping(value = "", method = RequestMethod.GET)
    //public void getMethod(){}

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String displayLogout(HttpSession session){
        session.invalidate();
        return "cinema-go/logout";
    }

}
