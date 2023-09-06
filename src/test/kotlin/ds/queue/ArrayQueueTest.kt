package ds.queue

import ds.queue.ArrayQueue
import ds.queue.Queue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

import kotlin.test.assertEquals

class ArrayQueueTest {

    private val size = 10
    private lateinit var queue: Queue<Int>

    @BeforeEach
    fun setup() {
        queue = ArrayQueue(size)
    }

    @Test
    fun `Test pop always matches pushed item`() {
        repeat(size) {
            queue.enqueue(it)
        }
        repeat(size) {
            assertEquals(it, queue.dequeue())
        }
    }

    @Test
    fun `Test capacity exceed throws`() {
        repeat(size) { queue.enqueue(it) }
        assertThrows<IndexOutOfBoundsException> {
            queue.enqueue(11)
        }
    }


    @Test
    fun `Test empty pop throws`() {
        assertThrows<NoSuchElementException> {
            queue.dequeue()
        }
    }
}