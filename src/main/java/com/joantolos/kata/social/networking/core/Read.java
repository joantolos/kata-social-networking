package com.joantolos.kata.social.networking.core;

import com.joantolos.kata.social.networking.domain.User;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.List;

public class Read extends TwitterCommand implements Command {

    public Read(String userName){
        super(userName);
    }

    @Override
    public Boolean process(UserInterface ui, List<User> users) {
        return true;
    }
}
