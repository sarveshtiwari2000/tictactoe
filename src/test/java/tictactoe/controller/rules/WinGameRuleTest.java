package tictactoe.controller.rules;

import org.junit.Assert;
import org.junit.Test;
import tictactoe.model.Field;
import tictactoe.model.Path;
import tictactoe.model.Player;

import java.util.ArrayList;
import java.util.List;

public class WinGameRuleTest {

    private final WinGameRule winGameRule = new WinGameRule();

    @Test
    public void noRuleChange() {
        List<Path> paths = new ArrayList<>();

        Field field = new Field(0, 0);
        field.assign(new Player('T'));
        Path pathA = new Path();

        pathA.add(new Field(0, 0));
        pathA.add(field);
        pathA.add(field);
        paths.add(pathA);

        winGameRule.executeLevel(new Player('X'), paths);
        Assert.assertTrue(pathA.countFreeFields() == 1);
    }

    @Test
    public void ruleChange() {
        List<Path> paths = new ArrayList<>();

        Field field = new Field(0, 0);
        field.assign(new Player('T'));
        Path pathA = new Path();

        pathA.add(new Field(0, 0));
        pathA.add(field);
        pathA.add(field);
        paths.add(pathA);

        winGameRule.executeLevel(new Player('T'), paths);
        Assert.assertTrue(pathA.hasWinner());
    }
}
