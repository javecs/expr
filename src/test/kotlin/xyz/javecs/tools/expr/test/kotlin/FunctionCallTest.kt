package xyz.javecs.tools.expr.test.kotlin

import kotlin.test.assertEquals
import org.junit.Test
import xyz.javecs.tools.expr.Calculator
import xyz.javecs.tools.expr.Function

class FunctionCallTest {
    @Test fun func1() {
        assertEquals(Double.NaN, Function("f(x,y)", arrayOf("x")).call(arrayOf(1.toDouble())))
        assertEquals(Double.NaN, Function("f(x)", arrayOf("x")).call(arrayOf(1.toDouble(), 2.toDouble())))
    }

    @Test fun func2() {
        val f = Function("f(x,y)", arrayOf("x * y"))
        assertEquals(12.toDouble(), f.call(arrayOf(3.toDouble(), 4.toDouble())))
        assertEquals(16.toDouble(), f.call(arrayOf(4.toDouble(), 4.toDouble())))
    }

    @Test fun func3() {
        val f = Function("f(x,y)", arrayOf("max(x,y)"))
        assertEquals(2.toDouble(), f.call(arrayOf(-1.toDouble(), 2.toDouble())))
        assertEquals(0.toDouble(), f.call(arrayOf(-1.02, 0.toDouble())))
    }

    @Test fun func4() {
        val f = Function("f(x,y,z)", arrayOf("a = x + y + z"))
        assertEquals("f", f.name)
        assertEquals(3, f.params.size)
        assertEquals(5.toDouble(), f.call(arrayOf(1.toDouble(), 2.toDouble(), 2.toDouble())))
    }

    @Test fun func5() {
        val f = Function("f(x,y,z)", arrayOf("a = x + y + z", "a = 0"))
        assertEquals(0.toDouble(), f.call(arrayOf(1.toDouble(), 2.toDouble(), 2.toDouble())))
    }

    @Test fun func7() {
        val f = Function("f()", arrayOf("100"))
        assertEquals(100.toDouble(), f.call(emptyArray()))
    }
}

