package xyz.javecs.tools.expr.test.kotlin

import kotlin.test.assertEquals
import org.junit.Test
import xyz.javecs.tools.expr.Calculator

class CalculatorFunTest {
    @Test fun clearTest() {
        val calc = Calculator().eval("x = 3")
        assertEquals(3, calc.value)
        assertEquals(3, calc.eval("x").value)

        calc.clear()
        assertEquals(Double.NaN, calc.value)
        assertEquals(Double.NaN, calc.eval("x").value)
    }
}
