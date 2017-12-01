package com.joantolos.kata.social.networking.command;

import com.joantolos.kata.social.networking.domain.User;

import java.util.List;

public class TwitterCommand {

    private String userName;

    public TwitterCommand(String userName) {
        this.userName = userName;
    }

    public User getUser(List<User> users) {
        User foundUser = users.stream().filter(u -> u.getName().equals(userName)).findFirst().orElse(null);
        if(foundUser==null){
            User newUser = new User(userName);
            users.add(newUser);
            return newUser;
        }
        return foundUser;
    }

    public String getUserName() {
        return userName;
    }
}
