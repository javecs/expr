package xyz.javecs.tools.expr;

import org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest {
    @Test
    public void testEvaluator() {
        Assert.assertEquals(7, Evaluator.eval("3 + 4"));
    }
}
