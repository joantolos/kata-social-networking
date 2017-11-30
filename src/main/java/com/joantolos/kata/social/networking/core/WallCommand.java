package com.joantolos.kata.social.networking.core;

import com.joantolos.kata.social.networking.domain.Post;
import com.joantolos.kata.social.networking.domain.User;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WallCommand extends TwitterCommand implements Command {

    public WallCommand(String userName){
        super(userName);
    }

    @Override
    public String process(UserInterface ui, List<User> users) {
        User user = super.getUser(users);
        List<Post> postsToPrint = new ArrayList<>();
        postsToPrint.addAll(user.getWall().getPosts());
        user.getFollowedUsers().forEach(followedUser -> postsToPrint.addAll(followedUser.getWall().getPosts()));

        postsToPrint.sort(Comparator.comparing(Post::getDate));

        StringBuilder commandResult = new StringBuilder("");
        postsToPrint.forEach(post -> commandResult
                .append(" ")
                .append(post.getUser().getName())
                .append(" -> ")
                .append(post.getMessage())
                .append("\n"));

        return commandResult.toString();
    }
}
