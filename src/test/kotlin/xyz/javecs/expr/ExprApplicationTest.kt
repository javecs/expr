package xyz.javecs.expr

import kotlin.test.assertEquals
import org.junit.Test

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

}

