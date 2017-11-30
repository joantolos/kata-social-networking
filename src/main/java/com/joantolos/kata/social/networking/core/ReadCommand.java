package com.joantolos.kata.social.networking.core;

import com.joantolos.kata.social.networking.domain.User;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.List;

public class ReadCommand extends TwitterCommand implements Command {

    public ReadCommand(String userName){
        super(userName);
    }

    @Override
    public String process(UserInterface ui, List<User> users) {
        User user = super.getUser(users);
        StringBuilder commandResult = new StringBuilder("");
        user.getWall().getPosts().forEach(post -> commandResult.append(" ").append(post.getMessage()).append("\n"));
        return commandResult.toString();
    }
}
