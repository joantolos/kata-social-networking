package com.joantolos.kata.social.networking.service;

import com.joantolos.kata.social.networking.entity.User;

import java.util.ArrayList;
import java.util.List;

public class TwitterService {

    private List<User> users;

    public TwitterService(){
        this.users = new ArrayList<>();
    }

    public String post(String userName, String message) {
        User user = getUser(userName);
        user.getWall().addPost(user, message);
        return "Message posted!";
    }

    public String follow(String userName, String userNameToFollow) {
        getUser(userName).addUserToFollow(getUser(userNameToFollow));
        return userName + " now follows " + userNameToFollow;
    }

    public String wall(String userName) {
        return getUser(userName).getWall().print();
    }

    public List<User> getUsers() {
        return users;
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
