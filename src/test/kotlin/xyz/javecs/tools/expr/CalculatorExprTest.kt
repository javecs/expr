package xyz.javecs.tools.expr

import kotlin.test.assertEquals
import org.junit.Test

class CalculatorExprTest {
    @Test fun calcExpr1() {
        val expr = "3 + 4"
        assertEquals(7, Calculator(arrayOf(expr)).evaluate().value)
    }

    @Test fun calcExpr2() {
        val expr = "3 + 4"
        assertEquals(7, Calculator().evaluate(expr).value)
    }

    @Test fun calcExpr3() {
        val calc = Calculator(arrayOf("3 + 4", "30 + 40"))
        assertEquals(70, calc.evaluate().value)
    }

    @Test fun calcExpr4() {
        val calc = Calculator()
        assertEquals(7, calc.evaluate("3 + 4").value)
        assertEquals(8, calc.evaluate("3 + 5").value)
    }

    @Test fun calcExpr5() {
        val calc = Calculator(arrayOf("30 + 40"))
        assertEquals("70", calc.evaluate().toString())
    }

    @Test fun calcExpr6() {
        val calc = Calculator(arrayOf("x = 7"))
        assertEquals(7, calc.evaluate().value)
        assertEquals("x = 7", calc.evaluate().toString())
    }
}
