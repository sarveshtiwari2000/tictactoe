package tictactoe.controller.rules;

import org.junit.Assert;
import org.junit.Test;
import tictactoe.model.Field;
import tictactoe.model.Path;
import tictactoe.model.Player;

import java.util.ArrayList;
import java.util.List;

public class EmptyPathRuleTest {

    private final EmptyPathRule emptyPathRule = new EmptyPathRule();

    @Test
    public void emptyPathRule() {
        List<Path> paths = new ArrayList<>();

        Path pathA = new Path();

        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        paths.add(pathA);

        emptyPathRule.executeLevel(new Player('X'), paths);
        Assert.assertTrue(pathA.countFreeFields() == 2);
    }

    @Test
    public void nonEmptyPathRule() {
        List<Path> paths = new ArrayList<>();

        Field field = new Field(0, 0);
        field.assign(new Player('T'));
        Path pathA = new Path();

        pathA.add(field);
        pathA.add(field);
        pathA.add(new Field(0, 0));
        paths.add(pathA);

        emptyPathRule.executeLevel(new Player('X'), paths);
        Assert.assertTrue(pathA.countFreeFields() == 1);
    }

}
