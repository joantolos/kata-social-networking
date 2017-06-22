package com.joantolos.kata.tictactoe;

import com.joantolos.kata.tictactoe.Player;
import com.joantolos.kata.tictactoe.TicTacToe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

    private TicTacToe ticTacToe;
    private Player player1;
    private Player player2;

    @Before
    public void setUp(){
        this.ticTacToe = new TicTacToe(3,3);
        this.player1 = new Player(1);
        this.player2 = new Player(2);
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
        Assert.assertEquals("Move done!", this.ticTacToe.play(player1,1,1));
    }

    @Test
    public void shouldntMove(){
        this.ticTacToe.play(player1,1,1);
        Assert.assertEquals("Can not move there, position in use", this.ticTacToe.play(player2,1,1));
    }

    @Test
    public void canNotMoveTwice(){
        this.ticTacToe.play(player1,1,1);
        Assert.assertEquals("Can not move again", this.ticTacToe.play(player1, 1, 1));
    }

    @Test
    public void canNotMoveForFullBoard(){
        this.fullBoard();
        Assert.assertEquals("Game over! Nobody wins", this.ticTacToe.play(player2, 1, 1));
    }

    private void fullBoard() {
        this.ticTacToe.play(player1, 0, 0);
        this.ticTacToe.play(player2, 0, 1);
        this.ticTacToe.play(player1, 0, 2);
        this.ticTacToe.play(player2, 1, 0);
        this.ticTacToe.play(player1, 1, 1);
        this.ticTacToe.play(player2, 1, 2);
        this.ticTacToe.play(player1, 2, 0);
        this.ticTacToe.play(player2, 2, 1);
        this.ticTacToe.play(player1, 2, 2);
    }

}
