package com.joantolos.kata.social.networking.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private Wall wall;
    private List<User> followedUsers;

    public User(String name) {
        this.name = name;
        this.wall = new Wall();
        this.followedUsers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Wall getWall(){
        return this.wall;
    }

    public List<User> getFollowedUsers() {
        return followedUsers;
    }

    public void addUserToFollow(User user) {
        this.followedUsers.add(user);
    }

}
