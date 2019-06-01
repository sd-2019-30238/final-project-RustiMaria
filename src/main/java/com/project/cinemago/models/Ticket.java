package com.project.cinemago.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketId;
    @NotNull
    private int movieId;
    @NotNull
    private float price;
    @NotNull
    private int discount;
    @NotNull
    public Ticket(){}

    public Ticket(@NotNull int movieId, @NotNull float price, @NotNull int discount) {
        this.movieId = movieId;
        this.price = price;
        this.discount = discount;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
