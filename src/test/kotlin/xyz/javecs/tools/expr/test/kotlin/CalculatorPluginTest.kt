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
        val calc = Calculator()
                .plugin(Function("f(x,y)", arrayOf("x + y")))
                .plugin(Function("g(x,y,z)", arrayOf("f(x,y) + z")))
        assertEquals(6, calc.eval("g(1,2,3)").value)
    }
}
