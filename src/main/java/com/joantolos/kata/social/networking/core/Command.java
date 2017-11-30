package com.joantolos.kata.social.networking.core;

import com.joantolos.kata.social.networking.domain.User;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.List;

public interface Command {

    Boolean process(UserInterface ui, List<User> users);
}
