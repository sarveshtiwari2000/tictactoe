package tictactoe.controller.rules;

import tictactoe.controller.rules.FreeFieldPathRule;
import tictactoe.view.OutputValue;
import tictactoe.model.Path;
import tictactoe.model.Player;

import java.util.List;

public class PathOfOtherRule implements Rule {

    @Override
    public boolean executeLevel(Player player, List<Path> paths) {
        paths.sort(new FreeFieldPathRule());
        for (Path path : paths) {
            if (path.containsSamePlayerOnly() && path.countFreeFields() > 0) {
                path.getFirstFreeField().assign(player);
                OutputValue.debug("Path Of Other !");
                return true;
            }
        }
        return false;
    }
}
