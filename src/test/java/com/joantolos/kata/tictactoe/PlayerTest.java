package com.joantolos.kata.tictactoe;

import com.joantolos.kata.tictactoe.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by joan on 21/06/2017.
 */
public class PlayerTest {

    private Player player1;

    @Before
    public void setUp(){
        this.player1 = new Player(1);
    }

    @Test
    public void shouldHaveAPlayer(){
        Assert.assertNotNull(player1);
    }
}
