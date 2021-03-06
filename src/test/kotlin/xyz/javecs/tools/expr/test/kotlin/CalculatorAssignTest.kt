package xyz.javecs.tools.expr.test.kotlin

import kotlin.test.assertEquals
import org.junit.Test
import xyz.javecs.tools.expr.Calculator

class CalculatorAssignTest {
    @Test fun calcAssign1() {
        val expr = "x = 3 + 4"
        assertEquals(7, Calculator(arrayOf(expr)).eval("x").value)
    }

    @Test fun calcAssign2() {
        val calc = Calculator(arrayOf("x = 3 + 4", "y = 30 + 40"))
        assertEquals(70, calc.eval().value)
    }

    @Test fun calcAssign3() {
        val calc = Calculator(arrayOf("x = 3 + 4", "y = 30 + 40", "x + y"))
        assertEquals(77, calc.eval().value)
    }

    @Test fun calcAssign4() {
        val calc = Calculator(arrayOf("x = 3 + 4", "y = 30 + 40", "x"))
        assertEquals(7, calc.eval().value)
    }

    @Test fun calcAssign5() { // Eは変えられません。
        val calc = Calculator()
        assertEquals(Math.E, calc.eval("e = 0").value)
        assertEquals(Math.E, calc.eval("E = 1").value)
    }

    @Test fun calcAssign6() { // PIは変えられません。
        val calc = Calculator()
        assertEquals(Math.PI, calc.eval("pi = 0").value)
        assertEquals(Math.PI, calc.eval("PI = 1").value)
    }

}
