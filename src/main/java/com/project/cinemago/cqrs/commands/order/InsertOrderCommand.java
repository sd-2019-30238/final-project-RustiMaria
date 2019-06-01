package com.project.cinemago.cqrs.commands.order;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.models.Order;

public class InsertOrderCommand implements ICommand {

    private Order order;

    public InsertOrderCommand(Order oreder){
        this.order = order;
    }

    public Order getOrder(){
        return this.order;
    }

    @Override
    public String getCommandName() {
        return "insertOrder";
    }
}
