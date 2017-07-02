package com.joantolos.kata.tictactoe;

import com.joantolos.kata.tictactoe.exception.NotEnoughPlayersException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TicTacToe {

    public static final int NUMBER_OF_PLAYERS = 2;
    private Board board;
    private List<Player> players;
    private Game game;

    public String start() throws NotEnoughPlayersException {
        if(!correctNumberOfPlayers()){
            throw new NotEnoughPlayersException();
        }
        board = new Board();
        players = new ArrayList<Player>();
        String gameId = UUID.randomUUID().toString();
        game = new Game(gameId);
        return gameId;
    }

    public boolean addPlayer(String name) {
        players.add(new Player(name));
        return true;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean correctNumberOfPlayers() {
        return players.size() == NUMBER_OF_PLAYERS;
    }
}
