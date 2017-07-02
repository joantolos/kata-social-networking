package com.joantolos.kata.tictactoe.game;

import com.joantolos.kata.tictactoe.exception.MoveNotAvailableException;
import com.joantolos.kata.tictactoe.exception.NotEnoughPlayersException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game game;

    @Before
    public void setUp(){
        game = new Game("testGame");
    }

    @After
    public void tearDown(){
        game = null;
    }

    @Test
    public void shouldNotBeCorrectNumberOfPlayers(){
        Assert.assertFalse(game.correctNumberOfPlayers());
    }

    @Test
    public void shouldBeCorrectNumberOfPlayers(){
        game.addPlayer("Joan");
        game.addPlayer("Nuria");
        Assert.assertTrue(game.correctNumberOfPlayers());
    }

    @Test
    public void shouldMakeMove(){
        game.addPlayer("Joan");
        game.addPlayer("Nuria");
        try {
            game.move("Joan", 0, 1);
        } catch (MoveNotAvailableException | NotEnoughPlayersException e) {
            Assert.fail();
        }
    }
}
