package com.joantolos.kata.tictactoe;

import com.joantolos.kata.tictactoe.exception.NotEnoughPlayersException;
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
    public void shouldAddPlayerTest(){
        Assert.assertTrue(ticTacToe.addPlayer("Joan"));
        Assert.assertEquals("Joan", ticTacToe.getPlayers().get(0).getName());
    }

    @Test
    public void shouldNotBeEnoughPlayers(){
        Assert.assertFalse(ticTacToe.correctNumberOfPlayers());
    }

    @Test
    public void shouldBeEnoughPlayers(){
        TicTacToe ticTacToePlayer = new TicTacToe();
        ticTacToePlayer.addPlayer("Joan");
        ticTacToePlayer.addPlayer("Nuria");
        Assert.assertTrue(ticTacToePlayer.correctNumberOfPlayers());
    }

    @Test(expected = NotEnoughPlayersException.class)
    public void gameShouldNotStartWithNotEnoughPlayers() throws NotEnoughPlayersException {
        ticTacToe.start();
    }

    @Test
    public void gameShouldStartWithTwoPlayers() {
        ticTacToe.addPlayer("Joan");
        ticTacToe.addPlayer("Nuria");
        try {
            ticTacToe.start();
        } catch (NotEnoughPlayersException e) {
            Assert.fail();
        }
    }
}
