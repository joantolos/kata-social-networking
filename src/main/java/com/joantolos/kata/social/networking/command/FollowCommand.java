package com.joantolos.kata.social.networking.command;

import com.joantolos.kata.social.networking.domain.User;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.List;

public class FollowCommand extends SocialNetworkingCommand implements Command {

    private String userNameToFollow;

    public FollowCommand(String userName, String userNameToFollow) {
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
