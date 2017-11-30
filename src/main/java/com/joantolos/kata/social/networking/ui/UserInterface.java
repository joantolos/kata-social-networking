package com.joantolos.kata.social.networking.ui;

import com.joantolos.kata.social.networking.domain.Post;
import com.joantolos.kata.social.networking.domain.TimeLapse;
import com.joantolos.kata.social.networking.time.Clock;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserInterface {

    public String postToPrint(List<Post> postsToPrint, Boolean toWall) {
        postsToPrint.sort(Comparator.comparing(Post::getDate));
        Collections.reverse(postsToPrint);

        StringBuilder posts = new StringBuilder("");
        postsToPrint.forEach(post -> {
            if(toWall){
                posts
                        .append(post.getUser().getName())
                        .append(" -> ")  ;
            }
            posts
                    .append(post.getMessage())
                    .append(" ")
                    .append(timeLapse(post.getDate()))
                    .append("\n");
            }
        );

        return posts.toString();
    }

    private String timeLapse(Timestamp postDate) {
        Clock clock = new Clock();
        TimeLapse lapse = clock.getTimeLapse(postDate);
        return "(" +
                String.valueOf(lapse.getTime()) +
                " " +
                lapse.getMagnitude() +
                " " +
                "ago)";
    }

    public String post() {
        return "Message posted!\n";
    }

    public String follow(String userName, String userNameToFollow) {
        return userName + " now follows " + userNameToFollow + "\n";
    }

    public Boolean prompt(){
        System.out.print("kata-social-network > \n");
        return true;
    }

    public Boolean print(String toPrint){
        System.out.print(toPrint);
        return true;
    }

    public Boolean exit() {
        System.out.print("Bye!\n");
        return true;
    }
}
