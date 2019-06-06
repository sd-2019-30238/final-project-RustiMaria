package com.project.cinemago.controllers;

import com.project.cinemago.dao.MovieDAO;
import com.project.cinemago.models.Movie;
import com.project.cinemago.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cinema/buy")
public class BuyTicketController {

    @Autowired
    private MovieDAO movieDAO;
    private int movieId;

    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    public String buyTicketGet(@PathVariable("movieId") int movieId, Model model, HttpSession session){
        User user = (User)session.getAttribute("user-entity");
        if(user == null){
            return "cinema-go/loginNeeded";
        }
        int rows = 10;
        int cols = 0;
        this.movieId = movieId;
        Movie movie = movieDAO.findMovieById(movieId);
        String hallType = movie.getHallType();
        if(hallType.equals("A")){
            cols = 8;
        }
        if(hallType.equals("B")){
            cols = 9;
        }
        if(hallType.equals("C")){
            cols = 10;
        }
        model.addAttribute("rows", rows);
        model.addAttribute("cols", cols);
        return "cinema-go/buy";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String buyTicketPost(@RequestParam int row, @RequestParam int col, HttpSession session){

        Movie movie = movieDAO.findMovieById(movieId);
        int[][] seats = movie.getSeats();
        if(seats[row-1][col-1] == 1){
            return "redirect:/cinema/seatError";
        }
        else{
            seats[row-1][col-1] = 1;
            movie.setSeats(seats);
        }

        session.setAttribute("movieId", movieId);
        return "redirect:/cinema/cart";
    }

}