package com.joantolos.kata.tictactoe.game;

import com.joantolos.kata.tictactoe.exception.MoveNotAvailableException;
import com.joantolos.kata.tictactoe.exception.NotEnoughPlayersException;

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
        players.add(new Player(name, calculateSymbol()));
        return true;
    }

    protected boolean correctNumberOfPlayers() {
        return players.size() == NUMBER_OF_PLAYERS;
    }

    protected String calculateSymbol(){
        if(players.size()==1) return "O";
        return "X";
    }

    public void move(String playerName, int x, int y) throws MoveNotAvailableException, NotEnoughPlayersException {
        if(notEnoughPlayers()){
            throw new NotEnoughPlayersException();
        }
        board.recordMove(x, y, foundPlayerByName(playerName).getSymbol());
    }

    private boolean notEnoughPlayers() {
        return players.size()!= NUMBER_OF_PLAYERS;
    }

    private Player foundPlayerByName(String playerName) throws NotEnoughPlayersException {
        return players.stream().filter(player -> player.getName().equals(playerName)).findFirst().orElseThrow(NotEnoughPlayersException::new);
    }

    public String print() {
        return "GAME ID: " + id + "\n" + "\n" +
                "Player " + players.get(0).getName() + " with symbol: " + players.get(0).getSymbol() + "\n" +
                "Player " + players.get(1).getName() + " with symbol: " + players.get(1).getSymbol() + "\n" + "\n" +
                board.print();
    }
}
