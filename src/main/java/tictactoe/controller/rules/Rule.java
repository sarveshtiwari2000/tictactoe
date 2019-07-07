package tictactoe.controller.rules;

import tictactoe.model.Path;
import tictactoe.model.Player;

import java.util.List;

public interface Rule {

    boolean executeLevel(Player player, List<Path> paths);
}
