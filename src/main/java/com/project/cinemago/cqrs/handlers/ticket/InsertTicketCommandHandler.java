package com.project.cinemago.cqrs.handlers.ticket;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.cqrs.commands.ticket.InsertTicketCommand;
import com.project.cinemago.cqrs.handlers.ICommandHandler;
import com.project.cinemago.dao.TicketDAO;
import com.project.cinemago.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class InsertTicketCommandHandler implements ICommandHandler {

    @Autowired
    private TicketDAO ticketDAO;

    @Override
    public void execute(ICommand command) throws SQLException {
        Ticket ticket = ((InsertTicketCommand)command).getTicket();
        ticketDAO.save(ticket);
    }
}
