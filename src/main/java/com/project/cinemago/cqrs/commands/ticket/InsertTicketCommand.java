package com.project.cinemago.cqrs.commands.ticket;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.models.Ticket;

public class InsertTicketCommand implements ICommand {

    private Ticket ticket;

    public InsertTicketCommand(Ticket ticket){
        this.ticket = ticket;
    }

    public Ticket getTicket(){
        return this.ticket;
    }

    @Override
    public String getCommandName() {
        return "insertTicket";
    }
}
