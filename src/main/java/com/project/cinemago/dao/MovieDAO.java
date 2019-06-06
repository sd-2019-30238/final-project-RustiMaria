package com.project.cinemago.dao;

import com.project.cinemago.models.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MovieDAO extends CrudRepository<Movie, Integer> {

    @Query("select m from Movie m where m.movieId = ?1")
    public Movie findMovieById(int id);

    @Query("select m from Movie m where m.movieName = ?1")
    public Movie findMovieByName(String name);

}
