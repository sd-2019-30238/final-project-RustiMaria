package com.project.cinemago.cqrs.handlers.orderInfo;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.cqrs.commands.orderInfo.InsertOrderInfoCommand;
import com.project.cinemago.cqrs.handlers.ICommandHandler;
import com.project.cinemago.dao.OrderInfoDAO;
import com.project.cinemago.models.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class InsertOrderInfoCommandHandler implements ICommandHandler {

    @Autowired
    private OrderInfoDAO orderDAO;

    @Override
    public void execute(ICommand command) throws SQLException {
        OrderInfo order = ((InsertOrderInfoCommand)command).getOrderInfo();
        orderDAO.save(order);
    }

}
