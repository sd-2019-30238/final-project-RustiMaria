package com.project.cinemago.cqrs.queries.order;

import com.project.cinemago.dao.OrderDAO;
import com.project.cinemago.models.Order;

import java.sql.SQLException;
import java.util.List;

public class FindOrdersByUserId {

    private static OrderDAO orderDAO;

    public static List<Order> findOrdersByUserId(int id) throws SQLException {

        return orderDAO.findOrdersByUserId(id);

    }

}
