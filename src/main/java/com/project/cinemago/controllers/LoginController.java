package com.project.cinemago.controllers;

import com.project.cinemago.dao.UserDAO;
import com.project.cinemago.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("cinema/login")
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String displayLoginForm(){
        return "cinema-go/login";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String getLoginInfo(@RequestParam String username, @RequestParam String password, HttpSession session, Model model){
        User user = userDAO.findUser(username, password);
        if(user == null) {
            return "cinema-go/loginError";
        }
        else{
            HttpServletRequest request = null;
            session.setAttribute("user-entity",user);
            model.addAttribute("username", user.getUsername());
            if(user.getUsername().equals("admin")){
                return "cinema-go/admin";
            }
            else{
                return "cinema-go/loginSuccess";
            }
        }
    }

}
