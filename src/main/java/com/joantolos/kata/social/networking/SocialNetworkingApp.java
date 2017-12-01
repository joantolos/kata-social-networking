package com.joantolos.kata.social.networking;

import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.Scanner;

public class SocialNetworkingApp {

    public static void main (String[] args){
        UserInterface ui = new UserInterface();
        SocialNetworking socialNetworking = new SocialNetworking(ui);
        Boolean exit;

        do {
            ui.prompt();
            String consoleCommand = new Scanner(System.in).nextLine();
            String commandResult = socialNetworking.processCommand(consoleCommand);
            exit = socialNetworking.printCommandResult(commandResult);
        } while (exit);
        ui.exit();
    }
}
