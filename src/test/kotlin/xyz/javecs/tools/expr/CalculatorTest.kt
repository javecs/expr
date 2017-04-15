package xyz.javecs.tools.expr

import kotlin.test.assertEquals
import org.junit.Test

class CalculatorTest {
    @Test fun calcExpr1() {
        val expr = "3 + 4"
        assertEquals(7, Calculator(arrayOf(expr)).evaluate().getValue())
    }

    @Test fun calcExpr2() {
        val expr = "3 + 4"
        assertEquals(7, Calculator().evaluate(expr).getValue())
    }

    @Test fun calcExpr3() {
        val calc = Calculator(arrayOf("3 + 4", "30 + 40"))
        assertEquals(70, calc.evaluate().getValue())
    }

    @Test fun calcExpr4() {
        val calc = Calculator()
        assertEquals(7, calc.evaluate("3 + 4").getValue())
        assertEquals(8, calc.evaluate("3 + 5").getValue())
    }

    @Test fun calcExpr5() {
        val calc = Calculator(arrayOf("30 + 40"))
        assertEquals("70", calc.evaluate().toString())
    }
}
