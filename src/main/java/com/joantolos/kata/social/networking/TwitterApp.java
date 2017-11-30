package com.joantolos.kata.social.networking;

import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.Scanner;

public class TwitterApp {

    public static void main (String[] args){
        UserInterface ui = new UserInterface();
        Twitter twitter = new Twitter(ui);
        Boolean exit;

        do {
            ui.print(" kata-social-network > ");
            String consoleCommand = new Scanner(System.in).nextLine();
            String commandResult = twitter.processCommand(consoleCommand);
            exit = twitter.printCommandResult(commandResult);
        } while (exit);
    }
}
