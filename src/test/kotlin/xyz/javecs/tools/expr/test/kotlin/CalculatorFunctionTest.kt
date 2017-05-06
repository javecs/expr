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

    @Test fun atan2Test() {
        assertEquals(1.4056476493802699, Calculator().eval("atan2(90, 15)").value)
        assertEquals(Double.NaN, Calculator().eval("atan2(1)").value)
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

    @Test fun hypotTest() {
        assertEquals(5, Calculator().eval("hypot(3, 4)").value)
        assertEquals(Double.NaN, Calculator().eval("hypot(1)").value)
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

    @Test fun maxTest() {
        assertEquals(Math.PI, Calculator().eval("max(e, pi)").value)
        assertEquals(Double.NaN, Calculator().eval("max(1)").value)

    }

    @Test fun minTest() {
        assertEquals(Math.E, Calculator().eval("min(e, pi)").value)
        assertEquals(Double.NaN, Calculator().eval("min(1)").value)
    }

    @Test fun formatTest() {
        assertEquals(3, Calculator().eval("format(10/3, 0)").value)
        assertEquals(3, Calculator().eval("format(10/3, -1)").value)
        assertEquals(3.33, Calculator().eval("format(10/3, 2)").value)
        assertEquals(1.56, Calculator().eval("format(Tan(1), 2)").value)
        assertEquals(1.557, Calculator().eval("format(Tan(1), 3)").value)
        assertEquals(3.141592653589793, Calculator().eval("format(pi, 25)").value)
    }

}
