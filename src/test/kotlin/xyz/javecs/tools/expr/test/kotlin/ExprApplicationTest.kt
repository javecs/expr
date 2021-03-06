package xyz.javecs.tools.expr.test.kotlin

import kotlin.test.assertEquals
import org.junit.Test
import xyz.javecs.tools.expr.eval
import xyz.javecs.tools.expr.parserTree

class TestApplication {
    @Test fun evalTree() {
        assertEquals("(start (stat (expr (expr 3) + (expr 4))))", parserTree("3 + 4"))
    }

    @Test fun evalAdd() {
        assertEquals(7, eval("3 + 4"))
        assertEquals(7.5, eval("3.5 + 4"))
    }

    @Test fun evalSub() {
        assertEquals(-1, eval("3 - 4"))
        assertEquals(0.5, eval("4.5 - 4"))
    }

    @Test fun evalMul() {
        assertEquals(12, eval("3 * 4"))
        assertEquals(14.85, eval("4.5 * 3.3"))
    }

    @Test fun evalDiv() {
        assertEquals(12, eval("60 / 5"))
        assertEquals(Double.NaN, eval("1 / 0"))
    }

    @Test fun evalMod() {
        assertEquals(1, eval("7 % 3"))
    }

    @Test fun evalPow() {
        assertEquals(8, eval("2 ^ 3"))
        assertEquals(512, eval("2 ^ 3 ^ 2"))
    }

    @Test fun evalParens() {
        assertEquals(11, eval("3 + 4 * 2"))
        assertEquals(14, eval("(3 + 4) * 2"))
    }

    @Test fun evalSign() {
        assertEquals(-1, eval("-1"))
        assertEquals(1, eval("+1"))
        assertEquals(-4, eval("4 * -1"))
        assertEquals(1, eval("-1*-1"))
        assertEquals(0, eval("-1--1"))
        assertEquals(-2, eval("-1+-1"))
    }

}

