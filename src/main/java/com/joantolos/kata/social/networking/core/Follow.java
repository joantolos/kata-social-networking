package com.joantolos.kata.social.networking.core;

import com.joantolos.kata.social.networking.domain.User;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.List;

public class Follow extends TwitterCommand implements Command {

    private String userNameToFollow;

    public Follow(String userName, String userNameToFollow) {
        super(userName);
        this.userNameToFollow = userNameToFollow;
    }

    @Override
    public String process(UserInterface ui, List<User> users) {
        User user = super.getUser(users);
        user.addUserToFollow(getUserToFollow(users, userNameToFollow));
        return ui.follow(super.getUserName(), userNameToFollow);
    }

    private User getUserToFollow(List<User> users, String userNameToFollow) {
        return users.stream().filter(user -> user.getName().equals(userNameToFollow)).findFirst().orElse(null);
    }
}
