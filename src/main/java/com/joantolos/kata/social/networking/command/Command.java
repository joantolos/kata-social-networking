package com.joantolos.kata.social.networking.command;

import com.joantolos.kata.social.networking.domain.User;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.List;

public interface Command {

    String process(UserInterface ui, List<User> users);
}
