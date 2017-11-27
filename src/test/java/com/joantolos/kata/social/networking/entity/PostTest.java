package com.joantolos.kata.social.networking.entity;

import org.junit.Assert;
import org.junit.Test;

public class PostTest {

    @Test
    public void shouldCalculateTimeLapseInSeconds() {
        try {
            Post firstPost = new Post(new User("Joan"), "My post message");
            Thread.sleep(5000);

            Post secondPost = new Post(new User("Joan"), "My second post");

            System.out.println(firstPost.getTimeLapse());
            System.out.println(secondPost.getTimeLapse());

        } catch (InterruptedException e) {
            Assert.fail();
        }
    }
}
