package ds.queue

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

import kotlin.test.assertEquals

class UnorderedMaxPriorityQueueTest {

    private val size = 10
    private lateinit var queue: Queue<Int>
    private val comparator = Comparator<Int> { o1, o2 -> o1.compareTo(o2) }

    @BeforeEach
    fun setup() {
        queue = UnorderedMaxPriorityQueue(size, comparator)
    }

    @Test
    fun `Test pop always matches pushed item`() {
        repeat(size) { queue.enqueue(it) }
        repeat(size) {
            val expected = size - it - 1
            assertEquals(expected, queue.dequeue())
        }
    }

    @Test
    fun `Test capacity exceed throws`() {
        repeat(size) { queue.enqueue(it) }
        assertThrows<IndexOutOfBoundsException> {
            queue.enqueue(size + 1)
        }
    }


    @Test
    fun `Test empty pop throws`() {
        assertThrows<NoSuchElementException> {
            queue.dequeue()
        }
    }
}