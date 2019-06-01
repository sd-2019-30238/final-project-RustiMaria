package com.project.cinemago.cqrs.commands.movie;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.models.Movie;

public class InsertMovieCommand implements ICommand {

    private Movie movie;

    public InsertMovieCommand(Movie movie){
        this.movie = movie;
    }

    public Movie getMovie(){
        return this.movie;
    }

    @Override
    public String getCommandName() {
        return "insertMovie";
    }
}
