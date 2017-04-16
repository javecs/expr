package xyz.javecs.tools.expr.test.java;

import org.junit.Assert;
import org.junit.Test;
import xyz.javecs.tools.expr.Evaluator;

public class EvaluatorTest {
    @Test
    public void testEvaluator() {
        Assert.assertEquals(7, Evaluator.eval("3 + 4"));
    }
}
