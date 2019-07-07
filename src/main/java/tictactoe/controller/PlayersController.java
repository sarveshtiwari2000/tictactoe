package tictactoe.controller;

import tictactoe.exception.ConfigException;
import tictactoe.model.GameConfig;
import tictactoe.model.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayersController {

    public List<Player> load(GameConfig config) {
        Set<Player> result = new HashSet<>();
        Player first = new Player(config.getFirstPlayerChar());
        result.add(first);

        Player second = new Player(config.getSecondPlayerChar());

        if (first.equals(second)) {
            throw new ConfigException("Select unique characters for first and second players");
        }

        result.add(second);

        Player computer = new Player(config.getComputerPlayerChar(), false);

        if (result.contains(computer)) {
            throw new ConfigException("Computer player character already exists");
        }

        result.add(computer);

        return new ArrayList<>(result);
    }

    public List<Player> twoRobots() {
        List<Player> players = new ArrayList<>();
        players.add(new Player('O', false));
        players.add(new Player('X', false));
        return players;
    }

    public List<Player> singlePlayer() {
        List<Player> players = new ArrayList<>();
        players.add(new Player('O'));
        players.add(new Player('X', false));
        return players;
    }

}
