package ds.stack

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*
import kotlin.test.assertEquals

class LinkedStackTest {

    private lateinit var stack: Stack<Int>

    @BeforeEach
    fun setup() {
        stack = LinkedStack()
    }

    @Test
    fun `Test pop always matches pushed item`() {
        val size = 50
        repeat(size) {
            stack.push(it)
        }
        repeat(size) {
            val expected = size - it - 1
            assertEquals(expected, stack.pop())
        }
    }

    @Test
    fun `Test empty pop throws`() {
        assertThrows<EmptyStackException> {
            stack.pop()
        }
    }


    @Test
    fun `just make sure, you know`() {
        val strStack = LinkedStack<String>()
        strStack.push("Hello")
        strStack.push("There")
        strStack.push("How's")
        strStack.push("It")
        strStack.push("going")
        strStack.push("man")
        strStack.push("?")

        assertEquals("?", strStack.pop())
        assertEquals("man", strStack.pop())
        assertEquals("going", strStack.pop())
        assertEquals("It", strStack.pop())
        assertEquals("How's", strStack.pop())
        assertEquals("There", strStack.pop())
        assertEquals("Hello", strStack.pop())
    }
}