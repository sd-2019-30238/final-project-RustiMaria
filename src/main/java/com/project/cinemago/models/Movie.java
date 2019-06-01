package com.project.cinemago.models;

import com.project.cinemago.observer.Observable;
import com.project.cinemago.observer.Observer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie extends Observable {

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
    private String duration;
    @NotNull
    private String hallType;

    @Transient
    private List<Observer> observers = new ArrayList<Observer>();

    public Movie(){}

    public Movie(@NotNull String movieName, @NotNull String movieImage, @NotNull Date airDate, String duration, @NotNull String hallType) {
        this.movieName = movieName;
        this.movieImage = movieImage;
        this.airDate = airDate;
        this.duration = duration;
        this.hallType = hallType;
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
        this.notifyObservers("The air date for movie " + this.getMovieName() + " has changed from " + this.getAirDate() + " to " + airDate);
        this.airDate = airDate;
    }

    public @NotNull String getDuration() {
        return duration;
    }

    public void setDuration(@NotNull String duration) {
        this.duration = duration;
    }

    public String getHallType() {
        return hallType;
    }

    public void setHallType(String hallType) {
        this.notifyObservers("The hall for movie " + this.getMovieName() + " has changed from " + this.getHallType() + " to " + hallType);
        this.hallType = hallType;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for(Observer obs: observers) {
            obs.update(message);
        }
    }

}
