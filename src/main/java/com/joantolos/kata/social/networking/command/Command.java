package com.joantolos.kata.social.networking.command;

import com.joantolos.kata.social.networking.service.TwitterService;
import com.joantolos.kata.social.networking.ui.UserInterface;

public class Command {

    private TwitterService twitterService;
    private UserInterface ui;

    public Command(UserInterface ui){
        this.ui = ui;
        this.twitterService = new TwitterService();
    }

    public Boolean process(String line) {
        String[] lines = line.split(" ");
        switch (Commands.byName(lines[1])) {
            case POST:
                System.out.println(twitterService.post(lines[0], getMessage(lines)));
                return false;
            case WALL:
                System.out.println(twitterService.wall(lines[0]));
                return false;
            case FOLLOW:
                System.out.println(twitterService.follow(lines[0], lines[2]));
                return false;
            case EXIT:
                ui.exit();
                return true;
            default:
                return true;
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
