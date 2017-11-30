package com.joantolos.kata.social.networking.core;

import com.joantolos.kata.social.networking.domain.User;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.List;

public class Wall extends TwitterCommand implements Command {

    public Wall(String userName){
        super(userName);
    }

    @Override
    public String process(UserInterface ui, List<User> users) {
        return "not empty";
    }
}
