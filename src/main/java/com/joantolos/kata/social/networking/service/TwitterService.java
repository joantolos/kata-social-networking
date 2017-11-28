package com.joantolos.kata.social.networking.service;

import com.joantolos.kata.social.networking.entity.User;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class TwitterService {

    private List<User> users;
    private UserInterface ui;

    public TwitterService(UserInterface ui){
        this.ui = ui;
        this.users = new ArrayList<>();
    }

    public Boolean post(String userName, String message) {
        User user = getUser(userName);
        user.getWall().addPost(user, message);
        ui.print(ui.post());
        return true;
    }

    public Boolean follow(String userName, String userNameToFollow) {
        getUser(userName).addUserToFollow(getUser(userNameToFollow));
        ui.print(ui.follow(userName, userNameToFollow));
        return true;
    }

    public Boolean wall(String userName) {
        ui.print(ui.wall(getUser(userName)));
        return true;
    }
    
    private User getUser(String userName) {
        User foundUser = users.stream().filter(u -> u.getName().equals(userName)).findFirst().orElse(null);
        if(foundUser==null){
            User newUser = new User(userName);
            users.add(newUser);
            return newUser;
        }
        return foundUser;
    }
}
