package com.project.cinemago.cqrs.handlers.user;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.cqrs.commands.user.InsertUserCommand;
import com.project.cinemago.cqrs.handlers.ICommandHandler;
import com.project.cinemago.dao.UserDAO;
import com.project.cinemago.models.User;

import java.sql.SQLException;

public class InsertUserCommandHandler implements ICommandHandler {

    private UserDAO user;

    public void execute(ICommand command) throws SQLException {
        User user1 = ((InsertUserCommand)command).getUser();
        user.save(user1);
    }

}
