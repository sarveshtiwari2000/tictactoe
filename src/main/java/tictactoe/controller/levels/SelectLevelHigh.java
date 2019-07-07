package tictactoe.controller.levels;

import tictactoe.controller.rules.PathForMeRule;
import tictactoe.controller.rules.PathOfOtherRule;
import tictactoe.controller.rules.EmptyPathRule;
import tictactoe.controller.rules.RandomFieldRule;
import tictactoe.controller.rules.Rule;
import tictactoe.controller.rules.WinGameRule;
import tictactoe.model.Path;
import tictactoe.model.Player;
import tictactoe.model.Playfield;

import java.util.ArrayList;
import java.util.List;

public class SelectLevelHigh implements SelectLevel {

    private final List<Rule> addRule;

    public SelectLevelHigh() {
        this.addRule = new ArrayList<>();
        this.addRule.add(new WinGameRule());
        this.addRule.add(new PathForMeRule());
        this.addRule.add(new EmptyPathRule());
        this.addRule.add(new PathOfOtherRule());
        this.addRule.add(new RandomFieldRule());
    }

    @Override
    public void select(Player player, Playfield playfield) {
        List<Path> paths = playfield.getPaths();
        for (Rule rule : addRule) {
            if (rule.executeLevel(player, paths)) {
                break;
            }
        }
    }
}
