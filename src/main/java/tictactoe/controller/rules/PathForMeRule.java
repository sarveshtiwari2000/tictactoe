package tictactoe.controller.rules;

import tictactoe.controller.rules.FreeFieldPathRule;
import tictactoe.model.Path;
import tictactoe.model.Player;

import java.util.List;

public class PathForMeRule implements Rule {

    @Override
    public boolean executeLevel(Player player, List<Path> paths) {
        paths.sort(new FreeFieldPathRule());
        for (Path path : paths) {
            if (path.containsOnly(player) && path.countFreeFields() > 0) {
                path.getFirstFreeField().assign(player);
                return true;
            }
        }
        return false;
    }

}
