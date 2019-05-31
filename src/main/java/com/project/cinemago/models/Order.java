package com.project.cinemago.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @NotNull
    private int userId;
    @NotNull
    private float total;

    public Order(){}

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public float getTotal() {
        return total;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
