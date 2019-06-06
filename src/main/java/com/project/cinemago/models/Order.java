package com.project.cinemago.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @NotNull
    private int userId;
    @NotNull
    private float total;
    @NotNull
    private Date orderDate;

    public Order(){}

    public Order(int userId, float total, Date date){
        this.userId = userId;
        this.total = total;
        this.orderDate = date;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public int getUserId() {
        return this.userId;
    }

    public float getTotal() {
        return this.total;
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

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
