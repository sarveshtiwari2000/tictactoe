package tictactoe.controller.rules;

import tictactoe.view.OutputValue;
import tictactoe.model.Path;
import tictactoe.model.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmptyPathRule implements Rule {

    @Override
    public boolean executeLevel(Player player, List<Path> paths) {
        List<Path> copyPaths = new ArrayList<>(paths);
        Collections.shuffle(copyPaths);
        for (Path path : copyPaths) {
            if (path.isEmpty()) {
                path.getRandomFreeField().assign(player);
                OutputValue.debug("Empty Path!...");
                return true;
            }
        }
        return false;
    }

}
