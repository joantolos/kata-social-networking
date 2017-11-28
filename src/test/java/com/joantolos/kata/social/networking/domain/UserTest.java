package com.joantolos.kata.social.networking.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User alice;

    @Before
    public void setUp(){
        this.alice = new User("Alice");
    }

    @Test
    public void shouldHaveWall(){
        Assert.assertNotNull(this.alice.getWall());
    }

}
