package com.project.cinemago.cqrs.handlers.message;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.cqrs.commands.message.InsertMessageCommand;
import com.project.cinemago.cqrs.handlers.ICommandHandler;
import com.project.cinemago.dao.MessageDAO;
import com.project.cinemago.models.Message;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class InsertMessageCommandHandler implements ICommandHandler {

    @Autowired
    private MessageDAO messageDAO;

    @Override
    public void execute(ICommand command) throws SQLException {
        Message message = ((InsertMessageCommand)command).getMessage();
        messageDAO.save(message);
    }

}
