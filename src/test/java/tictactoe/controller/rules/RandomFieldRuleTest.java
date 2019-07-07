package tictactoe.controller.rules;

import org.junit.Assert;
import org.junit.Test;
import tictactoe.model.Field;
import tictactoe.model.Path;
import tictactoe.model.Player;

import java.util.ArrayList;
import java.util.List;

public class RandomFieldRuleTest {

    private final RandomFieldRule randomFieldRule = new RandomFieldRule();

    @Test
    public void randomFieldRule() {
        List<Path> paths = new ArrayList<>();

        Path pathA = new Path();

        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        paths.add(pathA);

        randomFieldRule.executeLevel(new Player('X'), paths);
        Assert.assertTrue(pathA.countFreeFields() == 4);
    }


}
