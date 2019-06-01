package com.project.cinemago.cqrs.handlers.movie;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.cqrs.commands.movie.InsertMovieCommand;
import com.project.cinemago.cqrs.handlers.ICommandHandler;
import com.project.cinemago.dao.MovieDAO;
import com.project.cinemago.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class InsertMovieCommandHandler implements ICommandHandler {

    @Autowired
    private MovieDAO movieDAO;

    @Override
    public void execute(ICommand command) throws SQLException {
        Movie movie = ((InsertMovieCommand)command).getMovie();
        System.out.println("inside handler: " + movie.getMovieName());
        movieDAO.save(movie);
    }

}
