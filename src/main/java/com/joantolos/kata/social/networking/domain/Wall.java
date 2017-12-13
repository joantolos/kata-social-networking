package com.joantolos.kata.social.networking.domain;

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
}
