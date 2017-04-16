package xyz.javecs.tools.expr.test.java;

import org.junit.Assert;
import org.junit.Test;
import xyz.javecs.tools.expr.Calculator;

public class CalculatorTest {
    @Test
    public void testCalculator() {
        Calculator calc = new Calculator();
        calc.eval("3 + 4");
        Number value = calc.getValue();
        Assert.assertEquals(7, value);
    }
}
