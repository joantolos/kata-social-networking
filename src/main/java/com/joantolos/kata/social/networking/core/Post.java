package com.joantolos.kata.social.networking.core;

import com.joantolos.kata.social.networking.domain.User;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.List;

public class Post extends TwitterCommand implements Command {

    private String message;

    public Post(String userName, String message){
        super(userName);
        this.message = message;
    }

    @Override
    public String process(UserInterface ui, List<User> users) {
        User user = super.getUser(users);
        user.getWall().addPost(user, message);
        return ui.post();
    }
}
