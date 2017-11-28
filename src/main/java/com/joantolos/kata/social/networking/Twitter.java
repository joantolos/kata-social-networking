package com.joantolos.kata.social.networking;

import com.joantolos.kata.social.networking.core.Command;
import com.joantolos.kata.social.networking.ui.UserInterface;

import java.util.Scanner;

public class Twitter {

    public static void main (String[] args){
        UserInterface ui = new UserInterface();
        Command command = new Command(ui);
        Boolean exit;

        do {
            ui.print(ui.prompt());
            exit = command.process(new Scanner(System.in).nextLine());
        } while (exit);
    }
}
