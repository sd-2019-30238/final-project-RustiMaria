package com.project.cinemago.controllers;

import com.project.cinemago.dao.MessageDAO;
import com.project.cinemago.dao.MovieDAO;
import com.project.cinemago.dao.OrderDAO;
import com.project.cinemago.dao.TicketDAO;
import com.project.cinemago.models.Message;
import com.project.cinemago.models.Movie;
import com.project.cinemago.models.Order;
import com.project.cinemago.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
@RequestMapping("/cinema/cart")
public class CartController {

    @Autowired
    private MovieDAO movieDAO;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private TicketDAO ticketDAO;
    @Autowired
    private MessageDAO msgDAO;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getMethod(HttpSession session){
        User user = (User)session.getAttribute("user-entity");
        int movieId = (int)session.getAttribute("movieId");
        Movie movie = movieDAO.findMovieById(movieId);
        Order order = new Order(user.getId(), movie.getPrice(), new Date(System.currentTimeMillis()));
        orderDAO.save(order);
        Message message = new Message("You booked a seat for " + movie.getMovieName() + " for " + movie.getAirDate() + " on " + new Date(System.currentTimeMillis()), user.getId());
        msgDAO.save(message);
        return "cinema-go/cart";
    }

}
