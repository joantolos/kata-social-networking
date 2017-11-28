package com.joantolos.kata.social.networking.ui;

import com.joantolos.kata.social.networking.core.TimeLapse;

public class UserInterface {

    public String prompt() {
        return " kata-social-network > ";
    }

    public String exit() {
        return " Bye! ";
    }

    public String createTimeLapse(TimeLapse lapse) {
        StringBuilder timeLapsePrint = new StringBuilder("");
        String time = "";
        String magnitude = "";

        if(lapse.getDays() > 0){
            time = String.valueOf(lapse.getDays());
            magnitude = "days";
        } else if(lapse.getHours() > 0){
            time = String.valueOf(lapse.getHours());
            magnitude = "hours";
        } else if(lapse.getMinutes() > 0){
            time = String.valueOf(lapse.getMinutes());
            magnitude = "minutes";
        } else if(lapse.getSeconds() > 0){
            time = String.valueOf(lapse.getSeconds());
            magnitude = "seconds";
        }

        timeLapsePrint.append("(")
                .append(time)
                .append(" ")
                .append(magnitude)
                .append(" ")
                .append("ago)");

        return timeLapsePrint.toString();
    }

    public void print(String toPrint){
        System.out.print(toPrint);
    }
}
