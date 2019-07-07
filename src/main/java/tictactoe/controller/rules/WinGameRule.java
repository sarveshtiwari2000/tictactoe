package tictactoe.controller.rules;

import tictactoe.view.OutputValue;
import tictactoe.model.Path;
import tictactoe.model.Player;

import java.util.List;

public class WinGameRule implements Rule {

    @Override
    public boolean executeLevel(Player player, List<Path> paths) {
        for (Path path : paths) {
            if (path.containsOnly(player) && path.countFreeFields() == 1) {
                path.getFirstFreeField().assign(player);
                OutputValue.debug("Win Game !");
                return true;
            }
        }
        return false;
    }
}