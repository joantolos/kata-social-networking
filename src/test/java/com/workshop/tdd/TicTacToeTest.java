package com.workshop.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

    private TicTacToe ticTacToe;

    @Before
    public void setUp(){
        this.ticTacToe = new TicTacToe(3,3);
    }

    @Test
    public void shouldStartGame(){
        Assert.assertNotNull(this.ticTacToe);
    }

    @Test
    public void shouldMarkAsEmpty(){
        Assert.assertTrue(this.ticTacToe.isPositionEmpty(1,1));
    }

    @Test
    public void shouldMove(){
        Assert.assertEquals("Move done!", this.ticTacToe.play(1,1,1));
    }

    @Test
    public void shouldntMove(){
        this.ticTacToe.play(1,1,1);
        Assert.assertEquals("Can not move there, position in use", this.ticTacToe.play(2,1,1));
    }

    @Test
    public void canNotMoveTwice(){
        this.ticTacToe.play(1,1,1);
        Assert.assertEquals("Can not move again", this.ticTacToe.play(1, 1, 1));
    }

}
