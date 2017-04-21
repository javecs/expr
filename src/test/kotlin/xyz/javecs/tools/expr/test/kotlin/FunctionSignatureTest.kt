package xyz.javecs.tools.expr.test.kotlin

import kotlin.test.assertEquals
import org.junit.Test
import xyz.javecs.tools.expr.Calculator
import xyz.javecs.tools.expr.Function
import xyz.javecs.tools.expr.validate
import kotlin.test.assertFails
import kotlin.test.assertTrue

class FunctionSignatureTest {
    @Test fun signature1() {
        val (name, params) = validate("f(x,y)")
        assertEquals("f", name)
        assertEquals("x", params[0])
        assertEquals("y", params[1])
    }

    @Test fun signature2() {
        val (name, params) = validate("f()")
        assertEquals("f", name)
        assertEquals(0, params.size)
    }

    @Test fun signature3() {
        val (name, params) = validate("abc (     )")
        assertEquals("abc", name)
        assertEquals(0, params.size)
    }

    @Test fun signature4() {
        val (name, params) = validate(" f123 ( abc , defh, d123456  )   ")
        assertEquals("f123", name)
        assertEquals("abc", params[0])
        assertEquals("defh", params[1])
        assertEquals("d123456", params[2])
    }

    @Test fun signature5() {
        arrayOf(" f", "f*", "ffff(", "1()").forEach {
            try {
                validate(it)
                assertFails {  }
            } catch (e: Exception) {
                assertTrue { true }
            }
        }
    }
}

