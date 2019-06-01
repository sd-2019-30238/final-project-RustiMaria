package com.project.cinemago.cqrs.commands.orderInfo;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.models.OrderInfo;

public class InsertOrderInfoCommand implements ICommand {

    private OrderInfo order;

    public InsertOrderInfoCommand(OrderInfo order){
        this.order = order;
    }

    public OrderInfo getOrderInfo(){
        return this.order;
    }

    @Override
    public String getCommandName() {
        return "insertOrderInfo";
    }
}
