package xyz.javecs.tools.expr.test.kotlin

import kotlin.test.assertEquals
import org.junit.Test
import xyz.javecs.tools.expr.Calculator
import xyz.javecs.tools.expr.eval

class CalculatorConstantTest {

    @Test fun constantPi() {
        val calc = Calculator()
        for (pi in arrayOf("pi", "pI", "PI", "Pi")) {
            assertEquals(Math.PI, eval(pi))
            assertEquals(Math.PI, calc.eval(pi).value)
        }
    }

    @Test fun constantE() {
        val calc = Calculator()
        for (e in arrayOf("E", "e")) {
            assertEquals(Math.E, eval(e))
            assertEquals(Math.E, calc.eval(e).value)
        }
    }
}
