package com.joantolos.kata.social.networking;

import com.joantolos.kata.social.networking.command.Command;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.Scanner;

public class Twitter {

    public static void main (String[] args){
        UserInterface ui = new UserInterface();
        Command command = new Command(ui);
        Scanner keyboard = new Scanner(System.in);
        Boolean exit;

        do {
            ui.prompt();
            exit = command.process(keyboard.nextLine());
        } while (!exit);
    }
}
