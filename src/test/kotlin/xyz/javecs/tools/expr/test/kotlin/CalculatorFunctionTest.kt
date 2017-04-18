package xyz.javecs.tools.expr.test.kotlin

import kotlin.test.assertEquals
import org.junit.Test
import xyz.javecs.tools.expr.Calculator

class CalculatorFunctionTest {
    @Test fun sinTest() {
        assertEquals(0, Calculator().eval("sin(0)").value)
        assertEquals(0.8414709848078965, Calculator().eval("sin(1)").value)
    }

    @Test fun cosTest() {
        assertEquals(1, Calculator().eval("cos(0)").value)
        assertEquals(0.5403023058681398, Calculator().eval("cos(1)").value)
    }

    @Test fun tanTest() {
        assertEquals(0, Calculator().eval("tan(0)").value)
        assertEquals(1.5574077246549023, Calculator().eval("tan(1)").value)
    }

    @Test fun caseInsensitiveTest() {
        assertEquals(0.8414709848078965, Calculator().eval("SIN(1)").value)
        assertEquals(0.5403023058681398, Calculator().eval("cOs(1)").value)
        assertEquals(1.5574077246549023, Calculator().eval("Tan(1)").value)
    }

}
