package com.project.cinemago.cqrs.mediator;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.cqrs.handlers.ICommandHandler;
import com.project.cinemago.cqrs.handlers.message.InsertMessageCommandHandler;
import com.project.cinemago.cqrs.handlers.movie.InsertMovieCommandHandler;
import com.project.cinemago.cqrs.handlers.order.InsertOrderCommandHandler;
import com.project.cinemago.cqrs.handlers.orderInfo.InsertOrderInfoCommandHandler;
import com.project.cinemago.cqrs.handlers.ticket.InsertTicketCommandHandler;
import com.project.cinemago.cqrs.handlers.user.InsertUserCommandHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mediator implements IMediator {

    private List<ICommandHandler> handlers;
    private Map<String, ICommandHandler> ch;

    public Mediator() {
        handlers = new ArrayList<ICommandHandler>();
        ch = new HashMap<String, ICommandHandler>();
        ch.put("insertUser", new InsertUserCommandHandler());
        ch.put("insertMessage", new InsertMessageCommandHandler());
        ch.put("insertOrder", new InsertOrderCommandHandler());
        ch.put("insertOrderInfo", new InsertOrderInfoCommandHandler());
        ch.put("insertMovie", new InsertMovieCommandHandler());
        ch.put("insertTicket", new InsertTicketCommandHandler());
    }

    @Override
    public void mediate(ICommand command) {
        ICommandHandler handler = ch.get(command.getCommandName());
        try {
            handler.execute(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addHandler(ICommandHandler handler) {
        handlers.add(handler);
    }
}
