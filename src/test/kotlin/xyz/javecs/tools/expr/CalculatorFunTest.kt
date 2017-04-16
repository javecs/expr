package xyz.javecs.tools.expr

import kotlin.test.assertEquals
import org.junit.Test

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
