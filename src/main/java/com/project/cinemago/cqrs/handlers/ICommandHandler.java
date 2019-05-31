package com.project.cinemago.cqrs.handlers;

import com.project.cinemago.cqrs.commands.ICommand;

import java.sql.SQLException;

public interface ICommandHandler {

    public void execute(ICommand command) throws SQLException;

}
