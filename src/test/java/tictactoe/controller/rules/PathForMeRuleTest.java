package tictactoe.controller.rules;

import org.junit.Assert;
import org.junit.Test;
import tictactoe.model.Field;
import tictactoe.model.Path;
import tictactoe.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PathForMeRuleTest {
    private final PathForMeRule pathForMeRule = new PathForMeRule();

    @Test
    public void pathForMeRule() {
        List<Path> paths = new ArrayList<>();

        Path pathA = new Path();

        Field field = new Field(0, 0);
        field.assign(new Player('T'));

        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        paths.add(pathA);

        Path pathB = new Path();
        pathB.add(new Field(0, 0));
        pathB.add(new Field(0, 0));
        pathB.add(field);
        paths.add(pathB);

        Path pathC = new Path();
        pathC.add(new Field(0, 0));
        pathC.add(field);
        pathC.add(field);
        paths.add(pathC);

        pathForMeRule.executeLevel(new Player('T'), paths);

        Assert.assertTrue(pathC.hasWinner());

    }
}
