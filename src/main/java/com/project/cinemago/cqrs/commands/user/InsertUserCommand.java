package com.project.cinemago.cqrs.commands.user;

import com.project.cinemago.models.User;

public class InsertUserCommand {

    private User user;

    public InsertUserCommand(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

}
