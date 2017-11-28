package com.joantolos.kata.social.networking.core;

import java.util.Arrays;

public enum Commands {

    POST("posting"),
    FOLLOW("following"),
    WALL("wall"),
    EXIT("exit");

    private String commandName;

    Commands(String commandName){
        this.commandName = commandName;
    }

    public static Commands byName(String name) {
        return Arrays.stream(Commands.values()).filter(c -> c.commandName.equals(name)).findFirst().orElse(null);
    }
}
