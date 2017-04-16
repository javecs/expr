package xyz.javecs.tools.expr

import kotlin.test.assertEquals
import org.junit.Test

class CalculatorAssignTest {
    @Test fun calcAssign1() {
        val expr = "x = 3 + 4"
        assertEquals(7, Calculator(arrayOf(expr)).evaluate("x").value)
    }

    @Test fun calcAssign2() {
        val calc = Calculator(arrayOf("x = 3 + 4", "y = 30 + 40"))
        assertEquals(70, calc.evaluate().value)
    }

    @Test fun calcAssign3() {
        val calc = Calculator(arrayOf("x = 3 + 4", "y = 30 + 40", "x + y"))
        assertEquals(77, calc.evaluate().value)
    }

    @Test fun calcAssign4() {
        val calc = Calculator(arrayOf("x = 3 + 4", "y = 30 + 40", "x"))
        assertEquals(7, calc.evaluate().value)
    }
}
