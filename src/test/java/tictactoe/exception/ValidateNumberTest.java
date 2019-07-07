package tictactoe.exception;

import org.junit.Assert;
import org.junit.Test;

public class ValidateNumberTest {

    @Test
    public void validateNumber() {
        Assert.assertTrue(ValidateNumber.isNumeric("10"));
        Assert.assertFalse(ValidateNumber.isNumeric("a"));
    }

}
