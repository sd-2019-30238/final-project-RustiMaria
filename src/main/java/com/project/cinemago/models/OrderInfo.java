package com.project.cinemago.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @NotNull
    private int ticketId;
    @NotNull
    private int quantity;

    public OrderInfo(){}

    public OrderInfo(int orderId, int ticketId, int quantity) {
        this.orderId = orderId;
        this.ticketId = ticketId;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
