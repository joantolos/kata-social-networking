package com.joantolos.kata.social.networking.core;

import com.joantolos.kata.social.networking.domain.User;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.List;

public class CommandFactory {

    private static String POST_PATTERN = "\\w+\\s+->\\s+[\\w\\s]+";
    private static String READ_PATTERN = "\\w+";
    private static String FOLLOW_PATTERN = "\\w+\\s+follows\\s+[\\w\\s]+";
    private static String WALL_PATTERN = "\\w+\\s+wall+";

    public static Command build(String command) {
        if (command.matches(POST_PATTERN)) {
            return new Post(command.split(" -> ")[0], command.split(" -> ")[1]);
        } else if (command.matches(READ_PATTERN)) {
            return new Read(command);
        } else if (command.matches(FOLLOW_PATTERN)) {
            return new Follow(command.split(" follows ")[0], command.split(" follows ")[1]);
        } else if (command.matches(WALL_PATTERN)) {
            return new Wall(command.split(" ")[0]);
        }
        return new BadCommand();
    }

    private static class BadCommand implements Command {
        @Override
        public String process(UserInterface ui, List<User> users) {
            return "";
        }
    }
}
