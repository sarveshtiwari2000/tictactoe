package tictactoe.model;

import org.junit.Assert;
import org.junit.Test;

public class FieldTest {

    @Test
    public void validField() {
        Field field = new Field(0, 1);
        Assert.assertFalse(field.isAssigned());
        field.assign(new Player('X'));
        Assert.assertTrue(field.isAssigned());
        Assert.assertEquals(new Player('X'), field.getAssigned());
    }

}
