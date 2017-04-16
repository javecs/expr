package xyz.javecs.tools.expr

import kotlin.test.assertEquals
import org.junit.Test

class CalculatorEvaluateTest {
    @Test fun calcEvaluateTest1() {
        val calc = Calculator()
                .evaluate("x=3")
                .evaluate("y=4")
                .evaluate("x+y")
        assertEquals(7, calc.value)
        assertEquals("7", calc.toString())
    }
}
