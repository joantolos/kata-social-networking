package com.joantolos.kata.social.networking.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Wall {

    private List<Post> posts;

    public Wall(){
        this.posts = new ArrayList<>();
    }

    public List<Post> getPosts() {
        return this.posts;
    }

    public List<Post> getPostsFromUser(User user){
        return this.posts.stream()
                .filter(u -> u.getUser().getName().equals(user.getName()))
                .collect(Collectors.toList());
    }

    public void addPost(User user, String message) {
        this.posts.add(new Post(user, message));
    }
}
