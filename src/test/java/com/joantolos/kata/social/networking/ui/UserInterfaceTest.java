package com.joantolos.kata.social.networking.ui;

import com.joantolos.kata.social.networking.domain.Post;
import com.joantolos.kata.social.networking.domain.TimeLapse;
import com.joantolos.kata.social.networking.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserInterfaceTest {

    private UserInterface ui;

    @Before
    public void setUp(){
        this.ui = new UserInterface();
    }

    @Test
    public void shouldPrintPosts(){
        List<Post> postToPrint = new ArrayList<>();
        postToPrint.add(new Post(new User("Joan"), "Hello there"));
        String wallPrint = this.ui.postToPrint(postToPrint,true);
        Assert.assertTrue(wallPrint.split("\n")[0].contains("Joan -> Hello there"));
    }

    @Test
    public void shouldPrintPrompt(){
        Assert.assertTrue(ui.prompt());
    }

    @Test
    public void shouldPrintExit(){
        Assert.assertTrue(ui.exit());
    }
}
