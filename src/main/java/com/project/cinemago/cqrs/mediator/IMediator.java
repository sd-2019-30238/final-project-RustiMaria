package com.project.cinemago.cqrs.mediator;

import com.project.cinemago.cqrs.commands.ICommand;
import com.project.cinemago.cqrs.handlers.ICommandHandler;

public interface IMediator {

    public void mediate(ICommand command);

    public void addHandler(ICommandHandler handler);

}
