package xyz.javecs.tools.expr.test.kotlin

import kotlin.test.assertEquals
import org.junit.Test
import xyz.javecs.tools.expr.Calculator

class CalculatorVariablesTest {
    @Test fun calcVariables1() {
        val calc = Calculator()
        calc.eval("x = 3")
        calc.eval("y = 4")
        calc.eval("z = x * y")
        val variables = calc.variables()
        assertEquals(variables["x"], 3.0)
        assertEquals(variables["y"], 4.0)
        assertEquals(variables["z"], 12.0)
    }
}
