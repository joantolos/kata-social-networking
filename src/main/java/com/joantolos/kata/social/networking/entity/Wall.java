package com.joantolos.kata.social.networking.entity;

import java.util.ArrayList;
import java.util.List;

public class Wall {

    private List<Post> posts;

    public Wall(){
        this.posts = new ArrayList<>();
    }

    public List<Post> getPosts() {
        return this.posts;
    }

    public void addPost(User user, String message) {
        this.posts.add(new Post(user, message));
    }

    public String print() {
        StringBuilder wall = new StringBuilder("");
        posts.forEach(post -> wall.append(post.getUser().getName()).append(" -> ").append(post.getMessage()).append("\n"));
        return wall.toString();
    }
}
