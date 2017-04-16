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
}
