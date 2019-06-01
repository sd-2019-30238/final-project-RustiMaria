package com.project.cinemago.cqrs.commands.message;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.models.Message;

public class InsertMessageCommand implements ICommand {

    private Message message;

    public InsertMessageCommand(Message message){
        this.message = message;
    }

    public Message getMessage(){
        return this.message;
    }

    @Override
    public String getCommandName() {
        return "insertMessage";
    }
}
