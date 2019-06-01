package com.project.cinemago.controllers;

import com.project.cinemago.dao.MessageDAO;
import com.project.cinemago.models.Message;
import com.project.cinemago.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cinema/messages")
public class MessagesController {

    @Autowired
    private MessageDAO msg;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getMethod(Model model, HttpSession session){
        User user = (User)session.getAttribute("user-entity");
        if(user == null){
            return "cinema-go/loginNeeded";
        }
        System.out.println(user.getId());
        Iterable<Message> messages = msg.findByUserId(user.getId());
//        for(Message m:messages){
//            System.out.println(m.getMessage());
//        }
        model.addAttribute("messages", messages);
        return "cinema-go/messages";
    }

}
