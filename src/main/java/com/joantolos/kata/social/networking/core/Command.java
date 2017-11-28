package com.joantolos.kata.social.networking.core;

import com.joantolos.kata.social.networking.service.TwitterService;
import com.joantolos.kata.social.networking.ui.UserInterface;

public class Command {

    private TwitterService twitterService;
    private UserInterface ui;

    public Command(UserInterface ui){
        this.ui = ui;
        this.twitterService = new TwitterService(ui);
    }

    public Boolean process(String line) {
        String[] lines = line.split(" ");
        switch (Commands.byName(lines[1])) {
            case POST:
                return twitterService.post(lines[0], getMessage(lines));
            case WALL:
                return twitterService.wall(lines[0]);
            case FOLLOW:
                return twitterService.follow(lines[0], lines[2]);
            case EXIT:
                ui.print(ui.exit());
                return false;
            default:
                return false;
        }
    }

    private static String getMessage(String[] lines) {
        StringBuilder message = new StringBuilder("");

        for(int i = 2; i< lines.length; i++){
            message.append(lines[i]).append(" ");
        }

        return message.toString();
    }
}
