package com.joantolos.kata.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int NUMBER_OF_PLAYERS = 2;

    private List<Player> players;
    private String id;
    private Board board;

    public Game(String gameId) {
        id = gameId;
        players = new ArrayList<>();
        board = new Board();
    }

    public String getId() {
        return id;
    }

    public boolean addPlayer(String name) {
        players.add(new Player(name));
        return true;
    }

    private boolean correctNumberOfPlayers() {
        return players.size() == NUMBER_OF_PLAYERS;
    }
}
