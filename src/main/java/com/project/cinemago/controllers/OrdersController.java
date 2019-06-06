package com.project.cinemago.controllers;

import com.project.cinemago.dao.OrderDAO;
import com.project.cinemago.models.Order;
import com.project.cinemago.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cinema/orders")
public class OrdersController {

    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getMethod(Model model, HttpSession session){
        User user = (User)session.getAttribute("user-entity");
        if(user == null){
            return "cinema-go/loginNeeded";
        }
        List<Order> orders = orderDAO.findOrdersByUserId(user.getId());
        model.addAttribute("orders", orders);
        return "cinema-go/orders";
    }

}
