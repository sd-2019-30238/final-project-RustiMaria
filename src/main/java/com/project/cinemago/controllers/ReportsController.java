package com.project.cinemago.controllers;

import com.project.cinemago.dao.MovieDAO;
import com.project.cinemago.dao.OrderDAO;
import com.project.cinemago.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cinema/reports")
public class ReportsController {

    @Autowired
    private MovieDAO movieDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getMethod(Model model){
        long moviesNo = movieDAO.count();
        long usersNo = userDAO.count();
        long ordersNo = orderDAO.count();
        List<String> reports = new ArrayList<String>();
        reports.add("There are " + moviesNo + " movies available.");
        reports.add("There are " + usersNo + " registered users.");
        reports.add(0 + " orders have been placed until now.");
        model.addAttribute("reports", reports);
        return "cinema-go/reports";
    }

}
