package ds.stack

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.util.EmptyStackException
import kotlin.test.assertEquals

class ResizableArrayStackTest {

    private val size = 10
    private lateinit var stack: Stack<Int>

    @BeforeEach
    fun setup() {
        stack = ResizableArrayStack(size)
    }

    @Test
    fun `Test pop always matches pushed item`() {
        val exceededSize = size * 4
        repeat(exceededSize) {
            stack.push(it)
        }
        repeat(exceededSize) {
            val expected = exceededSize - it - 1
            assertEquals(expected, stack.pop())
        }
    }


    @Test
    fun `Test capacity exceed does not throw`() {
        repeat(size) { stack.push(it) }
        assertDoesNotThrow {
            stack.push(11)
        }
    }


    @Test
    fun `Test empty pop throws`() {
        assertThrows<EmptyStackException> {
            stack.pop()
        }
    }
}