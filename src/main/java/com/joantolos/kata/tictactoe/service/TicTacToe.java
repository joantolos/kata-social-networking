package com.joantolos.kata.tictactoe.service;

import com.joantolos.kata.tictactoe.game.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TicTacToe {

    private List<Game> games;

    public TicTacToe(){
        games = new ArrayList<>();
    }

    public String startNewGame() {
        String gameId = UUID.randomUUID().toString();
        games.add(new Game(gameId));
        return gameId;
    }

    public boolean addPlayer(String gameId, String playerName) {
        return findGameById(gameId).addPlayer(playerName);
    }

    public Game findGameById(String gameId){
        return games.stream().filter(game -> game.getId().equals(gameId)).findFirst().orElse(null);
    }
}
