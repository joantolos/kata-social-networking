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
        StringBuilder wall = new StringBuilder("");

        List<Post> postsToPrint = this.wall.getPosts();
        followedUsers.forEach(followedUser -> postsToPrint.addAll(followedUser.getWall().getPostsFromUser(followedUser)));
        postsToPrint.sort(Comparator.comparing(Post::getDate));

        postsToPrint.forEach(post -> wall.append(post.getUser().getName()).append(" -> ").append(post.getMessage()).append(" ").append(post.getDate()).append("\n"));

        return wall.toString();
    }
}
