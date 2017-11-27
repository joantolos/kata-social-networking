package com.joantolos.kata.social.networking;

import com.joantolos.kata.social.networking.service.TwitterService;

import java.util.Scanner;

public class Twitter {

    public static void main (String[] args){
        TwitterService twitterService = new TwitterService();
        Scanner keyboard = new Scanner(System.in);
        Boolean exit = false;

        do {
            System.out.print(" kata-social-network > ");
            final String line = keyboard.nextLine();
            String[] lines = line.split(" ");
            String userName = lines[0];

            if(userName.equals("exit")){
                exit = true;
            } else {
                String command = lines[1];
                processCommand(twitterService, lines, userName, command);
            }

        } while (!exit);
    }

    private static void processCommand(TwitterService twitterService, String[] lines, String userName, String command) {
        switch (command) {
            case "posting":
                System.out.println(twitterService.post(userName, getMessage(lines)));
                break;
            case "wall":
                System.out.println(twitterService.wall(userName));
                break;
            case "following":
                System.out.println(twitterService.follow(userName, lines[2]));
                break;
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
