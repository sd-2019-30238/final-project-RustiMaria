package com.project.cinemago.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;
    @NotNull
    private String movieName;
    @NotNull
    private String movieImage;
    @NotNull
    private Date airDate;
    @NotNull
    private Time duration;
    @NotNull
    private int availableSeats;

    public Movie(){}

    public Movie(@NotNull String movieName, @NotNull String movieImage, @NotNull Date airDate, @NotNull Time duration, @NotNull int availableSeats) {
        this.movieName = movieName;
        this.movieImage = movieImage;
        this.airDate = airDate;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    public @NotNull Date getAirDate() {
        return airDate;
    }

    public void setAirDate(@NotNull Date airDate) {
        this.airDate = airDate;
    }

    public @NotNull Time getDuration() {
        return duration;
    }

    public void setDuration(@NotNull Time duration) {
        this.duration = duration;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
