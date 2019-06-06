package com.project.cinemago.controllers;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.cqrs.commands.movie.InsertMovieCommand;
import com.project.cinemago.cqrs.mediator.Mediator;
import com.project.cinemago.dao.MovieDAO;
import com.project.cinemago.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cinema/tasks")
public class TasksController {

    private Mediator mediator = new Mediator();
    @Autowired
    private MovieDAO movieDAO;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getMethod(Model model){
        List<Integer> ids = new ArrayList<Integer>();
        Iterable<Movie> movies = movieDAO.findAll();
        for(Movie m: movies){
            ids.add(m.getMovieId());
        }
        model.addAttribute("ids", ids);
        return "cinema-go/deleteMovie";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String manageTasks(HttpServletRequest request){
        if(request.getParameter("addMovie") != null){
            String movieName = request.getParameter("movieName");
            String movieImage = request.getParameter("movieImage");
            String airDateString = request.getParameter("airDate");
            String duration = request.getParameter("duration");
            String priceS = request.getParameter("price");
            float price = Float.parseFloat(priceS);
            String hallType = request.getParameter("hallType");

            Date airDate = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                java.util.Date utilDate = format.parse(airDateString);
                airDate = new java.sql.Date(utilDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Movie movie = new Movie(movieName, movieImage, airDate, duration, price, hallType.substring(hallType.length()-1, hallType.length()));
            ICommand command = new InsertMovieCommand(movie);
            //mediator.mediate(command);
            movieDAO.save(movie);
        }

        if(request.getParameter("updateMovie") != null){
            String idS = request.getParameter("movieId");
            int movieId = Integer.parseInt(idS);
            String priceS = request.getParameter("price");
            float price = Float.parseFloat(priceS);
            String airDateString = request.getParameter("airDate");
            String hall = request.getParameter("hallType");
            Date airDate = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                java.util.Date utilDate = format.parse(airDateString);
                airDate = new java.sql.Date(utilDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Movie movie = movieDAO.findMovieById(movieId);
            movie.setAirDate(airDate);
            movie.setHallType(hall.substring(hall.length()-1, hall.length()));
            movie.setPrice(price);
            movieDAO.deleteById(movieId);
            movieDAO.save(movie);
        }

        if(request.getParameter("deleteMovie") != null) {
            String idS = request.getParameter("movieId");
            int movieId = Integer.parseInt(idS);
            movieDAO.deleteById(movieId);
        }

        return "cinema-go/admin";
    }

}
