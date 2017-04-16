package xyz.javecs.tools.expr.test.kotlin

import kotlin.test.assertEquals
import org.junit.Test
import xyz.javecs.tools.expr.Calculator

class CalculatorExprTest {
    @Test fun calcExpr1() {
        val expr = "3 + 4"
        assertEquals(7, Calculator(arrayOf(expr)).eval().value)
    }

    @Test fun calcExpr2() {
        val expr = "3 + 4"
        assertEquals(7, Calculator().eval(expr).value)
    }

    @Test fun calcExpr3() {
        val calc = Calculator(arrayOf("3 + 4", "30 + 40"))
        assertEquals(70, calc.eval().value)
    }

    @Test fun calcExpr4() {
        val calc = Calculator()
        assertEquals(7, calc.eval("3 + 4").value)
        assertEquals(8, calc.eval("3 + 5").value)
    }

    @Test fun calcExpr5() {
        val calc = Calculator(arrayOf("30 + 40"))
        assertEquals("70", calc.eval().toString())
    }

    @Test fun calcExpr6() {
        val calc = Calculator(arrayOf("x = 7"))
        assertEquals(7, calc.eval().value)
        assertEquals("x = 7", calc.eval().toString())
    }
}
