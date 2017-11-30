package com.joantolos.kata.social.networking;

import com.joantolos.kata.social.networking.core.Command;
import com.joantolos.kata.social.networking.core.CommandFactory;
import com.joantolos.kata.social.networking.domain.User;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Twitter {

    private List<User> users;
    private UserInterface ui;

    public Twitter(UserInterface ui){
        this.ui = ui;
        this.users = new ArrayList<>();
    }

    public Boolean processCommand(String consoleCommand) {
        Command command = CommandFactory.build(consoleCommand);
        return command.process(ui, users);
    }
}
