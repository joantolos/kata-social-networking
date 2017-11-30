package com.joantolos.kata.social.networking.ui;

import com.joantolos.kata.social.networking.utils.Clock;
import com.joantolos.kata.social.networking.domain.TimeLapse;
import com.joantolos.kata.social.networking.domain.Post;
import com.joantolos.kata.social.networking.domain.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserInterface {

    public String wall(User user) {
        Clock clock = new Clock();
        List<Post> postsToPrint = new ArrayList<>();
        postsToPrint.addAll(user.getWall().getPosts());
        user.getFollowedUsers().forEach(followedUser -> postsToPrint.addAll(followedUser.getWall().getPosts()));

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

    protected String timeLapse(TimeLapse lapse) {
        StringBuilder timeLapsePrint = new StringBuilder("");
        Long time = null;
        String magnitude = "";

        if(lapse.getDays() > 0){
            time = (lapse.getDays());
            magnitude = time > 1L ? "days" : "day";
        } else if(lapse.getHours() > 0){
            time = lapse.getHours();
            magnitude = time > 1L ? "hours" : "hour";
        } else if(lapse.getMinutes() > 0){
            time = lapse.getMinutes();
            magnitude = time > 1L ? "minutes" : "minute";
        } else if(lapse.getSeconds() > 0){
            time = lapse.getSeconds();
            magnitude = time > 1L ? "seconds" : "second";
        }

        timeLapsePrint.append("(")
                .append(String.valueOf(time))
                .append(" ")
                .append(magnitude)
                .append(" ")
                .append("ago)");

        return timeLapsePrint.toString();
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
