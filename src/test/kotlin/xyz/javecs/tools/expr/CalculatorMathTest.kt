package xyz.javecs.tools.expr

import kotlin.test.assertEquals
import org.junit.Test

class CalculatorMathTest {
    @Test fun mathSin() {
        assertEquals(0, Calculator().evaluate("sin(0)").value)
        assertEquals(0.8414709848078965, Calculator().evaluate("sin(1)").value)
    }

    @Test fun mathCos() {
        assertEquals(1, Calculator().evaluate("cos(0)").value)
        assertEquals(0.5403023058681398, Calculator().evaluate("cos(1)").value)
    }

    @Test fun mathTan() {
        assertEquals(0, Calculator().evaluate("tan(0)").value)
        assertEquals(1.5574077246549023, Calculator().evaluate("tan(1)").value)
    }
}
