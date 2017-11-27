package com.joantolos.kata.social.networking.entity;

import java.util.ArrayList;
import java.util.Comparator;
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

    public void addUserToFollow(User user) {
        this.followedUsers.add(user);
    }

    public String printWall() {
        List<Post> postsToPrint = this.wall.getPosts();
        followedUsers.forEach(followedUser -> postsToPrint.addAll(followedUser.getWall().getPostsFromUser(followedUser)));

        StringBuilder wall = new StringBuilder("");
        postsToPrint.forEach(post -> wall
                .append(post.getUser().getName())
                .append(" -> ")
                .append(post.getMessage())
                .append(" (")
                .append(post.getTimeLapse())
                .append(")")
                .append("\n"));

        return wall.toString();
    }
}
