package ds.stack

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*
import kotlin.test.assertEquals

class ArrayStackTest {

    private val size = 10
    private lateinit var stack: Stack<Int>

    @BeforeEach
    fun setup() {
        stack = ArrayStack(size)
    }

    @Test
    fun `Test pop always matches pushed item`() {
        repeat(size) {
            stack.push(it)
        }
        repeat(size) {
            val expected = size - it - 1
            assertEquals(expected, stack.pop())
        }
    }

    @Test
    fun `Test capacity exceed throws`() {
        repeat(size) { stack.push(it) }
        assertThrows<IndexOutOfBoundsException> {
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