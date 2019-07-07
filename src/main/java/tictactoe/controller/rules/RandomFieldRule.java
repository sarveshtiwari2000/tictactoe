package tictactoe.controller.rules;

import tictactoe.model.Path;
import tictactoe.model.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomFieldRule implements Rule {

    @Override
    public boolean executeLevel(Player player, List<Path> paths) {
        List<Path> copyPaths = new ArrayList<>(paths);
        Collections.shuffle(copyPaths);
        for (Path path : copyPaths) {
            if (path.countFreeFields() > 0) {
                path.getRandomFreeField().assign(player);
                return true;
            }
        }
        return false;
    }
}
