package xyz.javecs.tools.expr;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testCalculator() {
        Calculator calc = new Calculator();
        calc.eval("3 + 4");
        Number value = calc.getValue();
        Assert.assertEquals(7, value);
    }
}
