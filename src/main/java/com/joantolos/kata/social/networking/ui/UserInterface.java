package com.joantolos.kata.social.networking.ui;

import com.joantolos.kata.social.networking.domain.Post;
import com.joantolos.kata.social.networking.domain.TimeLapse;
import com.joantolos.kata.social.networking.time.Clock;

import java.util.Comparator;
import java.util.List;

public class UserInterface {

    public String wall(List<Post> postsToPrint) {
        Clock clock = new Clock();
        postsToPrint.sort(Comparator.comparing(Post::getDate));

        StringBuilder wallPrint = new StringBuilder("");
        postsToPrint.forEach(post -> wallPrint
                .append(post.getUser().getName())
                .append(" -> ")
                .append(post.getMessage())
                .append(" ")
                .append(timeLapse(clock.getTimeLapse(post.getDate())))
                .append("\n"));

        return wallPrint.toString();
    }

    public String timeLapse(TimeLapse lapse) {
        return "(" +
                String.valueOf(lapse.getTime()) +
                " " +
                lapse.getMagnitude() +
                " " +
                "ago)";
    }

    public String post() {
        return " Message posted!\n";
    }

    public String follow(String userName, String userNameToFollow) {
        return " " + userName + " now follows " + userNameToFollow + "\n";
    }

    public void print(String toPrint){
        System.out.print(toPrint);
    }
}
