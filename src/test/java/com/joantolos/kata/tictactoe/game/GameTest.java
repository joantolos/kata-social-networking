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

    @Test(expected = NotEnoughPlayersException.class)
    public void shouldFailWhenNoPlayers() throws MoveNotAvailableException, NotEnoughPlayersException {
        game.move("Joan", 0,0);
    }

    @Test(expected = NotEnoughPlayersException.class)
    public void shouldFailWhenOnePlayer() throws MoveNotAvailableException, NotEnoughPlayersException {
        game.addPlayer("Joan");
        game.move("Joan", 0,0);
    }

    @Test
    public void shouldPassWhenEnoughPlayers() {
        game.addPlayer("Joan");
        game.addPlayer("Nuria");
        try {
            game.move("Joan", 0,0);
        } catch (MoveNotAvailableException | NotEnoughPlayersException e) {
            Assert.fail();
        }
    }

    @Test
    public void shouldPrint() throws MoveNotAvailableException, NotEnoughPlayersException {
        game.addPlayer("Joan");
        game.addPlayer("Nuria");
        game.move("Joan",0,0);
        game.move("Nuria",0,1);
        Assert.assertNotNull(game.print());
        System.out.println(game.print());
    }
}
