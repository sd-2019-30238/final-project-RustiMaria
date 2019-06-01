package com.project.cinemago.cqrs.commands.user;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.models.User;

public class InsertUserCommand implements ICommand {

    private User user;

    public InsertUserCommand(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    @Override
    public String getCommandName() {
        return "insertUser";
    }
}
