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

    @Test fun asinTest() {
        assertEquals(1.5707963267948966, Calculator().eval("asin(1)").value)
    }

    @Test fun acosTest() {
        assertEquals(1.5707963267948966, Calculator().eval("acos(0)").value)
    }

    @Test fun atanTest() {
        assertEquals(0.7853981633974483, Calculator().eval("atan(1)").value)
    }

    @Test fun expTest() {
        assertEquals(2.718281828459045, Calculator().eval("exp(1)").value)
    }

    @Test fun logTest() {
        assertEquals(0.6931471805599453, Calculator().eval("log(2)").value)
    }

    @Test fun log10Test() {
        assertEquals(0.3010299956639812, Calculator().eval("log10(2)").value)
    }

    @Test fun sqrtTest() {
        assertEquals(1.4142135623730951, Calculator().eval("sqrt(2)").value)
    }

    @Test fun sinhTest() {
        assertEquals(1.1752011936438014, Calculator().eval("sinh(1)").value)
    }

    @Test fun coshTest() {
        assertEquals(1.543080634815244, Calculator().eval("cosh(1)").value)
    }

    @Test fun tanhTest() {
        assertEquals(0.7615941559557649, Calculator().eval("tanh(1)").value)
    }

    @Test fun radTest() {
        assertEquals(0.017453292519943295, Calculator().eval("rad(1)").value)
    }

    @Test fun degTest() {
        assertEquals(57.29577951308232, Calculator().eval("deg(1)").value)
    }
}
