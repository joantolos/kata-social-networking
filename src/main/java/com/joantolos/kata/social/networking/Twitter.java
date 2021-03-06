package com.joantolos.kata.social.networking;

import com.joantolos.kata.social.networking.command.Command;
import com.joantolos.kata.social.networking.command.CommandFactory;
import com.joantolos.kata.social.networking.domain.User;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class Twitter {

    private List<User> users;
    private UserInterface ui;

    public Twitter(UserInterface ui){
        this.ui = ui;
        this.users = new ArrayList<>();
    }

    public String processCommand(String consoleCommand) {
        Command command = CommandFactory.build(consoleCommand);
        return command.process(ui, users);
    }

    public Boolean printCommandResult(String commandResult){
        if(!commandResult.isEmpty()){
            ui.print(commandResult);
            return true;
        }
        return false;
    }
}
