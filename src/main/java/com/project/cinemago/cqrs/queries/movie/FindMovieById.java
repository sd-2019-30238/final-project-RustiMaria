package com.project.cinemago.cqrs.queries.movie;

import com.project.cinemago.dao.MovieDAO;
import com.project.cinemago.models.Movie;

import java.sql.SQLException;
import java.util.Optional;

public class FindMovieById {

    private static MovieDAO movieDAO;

    public static Optional<Movie> findMovieById(int id) throws SQLException {

        return movieDAO.findById(id);

    }

}
