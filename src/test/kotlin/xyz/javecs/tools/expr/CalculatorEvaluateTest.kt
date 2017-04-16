package xyz.javecs.tools.expr

import kotlin.test.assertEquals
import org.junit.Test

class CalculatorEvaluateTest {
    @Test fun calcEvaluateTest1() {
        val calc = Calculator()
                .eval("x=3")
                .eval("y=4")
                .eval("x+y")
        assertEquals(7, calc.value)
        assertEquals("7", calc.toString())
    }

    @Test fun calcEvaluateTest2() {
        val calc = Calculator()
        assertEquals("x = 3", calc.eval("x=3").toString())
        assertEquals("y = 4", calc.eval("y=4").toString())
        assertEquals("y = 7", calc.eval("y=x+y").toString())
        assertEquals(7, calc.value)
    }
}
