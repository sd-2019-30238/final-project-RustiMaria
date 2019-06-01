package com.project.cinemago.cqrs.handlers.order;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.cqrs.commands.order.InsertOrderCommand;
import com.project.cinemago.cqrs.handlers.ICommandHandler;
import com.project.cinemago.dao.OrderDAO;
import com.project.cinemago.models.Order;

import java.sql.SQLException;

public class InsertOrderCommandHandler<Autowired> implements ICommandHandler {

    @org.springframework.beans.factory.annotation.Autowired
    private OrderDAO orderDAO;

    @Override
    public void execute(ICommand command) throws SQLException {
        Order order = ((InsertOrderCommand)command).getOrder();
        orderDAO.save(order);
    }

}
