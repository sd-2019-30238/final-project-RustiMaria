package com.project.cinemago.cqrs.queries.movie;

import com.project.cinemago.dao.MovieDAO;
import com.project.cinemago.models.Movie;

import java.sql.SQLException;

public class FindMovies {

    private static MovieDAO movieDAO;

    public static Iterable<Movie> findMovies() throws SQLException {

        return movieDAO.findAll();

    }

}
