package com.joantolos.kata.social.networking.core;

import com.joantolos.kata.social.networking.domain.User;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.List;

public class Follow extends TwitterCommand implements Command {

    private String userNameToFollow;

    public Follow(String userName, String userNameToFollow) {
        super(userName);
        this.userNameToFollow = userNameToFollow;
    }

    @Override
    public Boolean process(UserInterface ui, List<User> users) {
        return true;
    }
}
