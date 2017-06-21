package com.workshop.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

    private TicTacToe ticTacToe;

    @Before
    public void setUp(){
        ticTacToe = new TicTacToe(new Integer[3][3]);
    }
    
    @Test
    public void playerOnePlaysCenter(){
        boolean winner = ticTacToe.play(1,1,1);
        Assert.assertNotNull(winner);
    }
}
