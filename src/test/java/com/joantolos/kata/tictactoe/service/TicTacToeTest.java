package com.joantolos.kata.tictactoe.service;

import com.joantolos.kata.tictactoe.game.Game;
import com.joantolos.kata.tictactoe.service.TicTacToe;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

    private TicTacToe ticTacToe;

    @Before
    public void setUp(){
        ticTacToe = new TicTacToe();
    }

    @After
    public void tearDown(){
        ticTacToe = null;
    }

    @Test
    public void shouldStartNewGame() {
        Assert.assertNotNull(ticTacToe.startNewGame());
    }

    @Test
    public void shouldAddPlayer() {
        String gameId = ticTacToe.startNewGame();
        Assert.assertTrue(ticTacToe.addPlayer(gameId, "Joan"));
    }

    @Test
    public void shouldFindGameById(){
        String gameId = ticTacToe.startNewGame();
        Game foundedGame = ticTacToe.findGameById(gameId);
        Assert.assertNotNull(foundedGame);
        Assert.assertEquals(gameId, foundedGame.getId());
    }
}
