package com.joantolos.kata.social.networking;

import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.Scanner;

public class TwitterApp {

    public static void main (String[] args){
        UserInterface ui = new UserInterface();
        Twitter twitter = new Twitter(ui);
        Boolean commandProcessedOK;

        do {
            ui.prompt();
            String consoleCommand = new Scanner(System.in).nextLine();
            String commandResult = twitter.processCommand(consoleCommand);
            commandProcessedOK = twitter.printCommandResult(commandResult);
        } while (commandProcessedOK);
        ui.exit();
    }
}
