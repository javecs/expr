package xyz.javecs.tools.expr.test.kotlin

import kotlin.test.assertEquals
import org.junit.Test
import xyz.javecs.tools.expr.Calculator
import xyz.javecs.tools.expr.Function

class CalculatorPluginTest {
    @Test fun plugin1() {
        val calc = Calculator()
        calc.plugin(Function("f(x,y)", arrayOf("x + y")))
        assertEquals(3, calc.eval("f(1,2)").value)
    }

    @Test fun plugin2() {
        val value = Calculator()
                .plugin(Function("f(x)", arrayOf("x + 1")))
                .plugin(Function("g(x,y)", arrayOf("f(x) * y")))
                .eval("x = 3")
                .eval("y = 4")
                .eval("g(x,y)")
                .value
        assertEquals(16, value)
    }
}
