package algorithms.sort

import algorithms.sort.mergesort.MergeSortRecursive
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class MergeSortRecursiveTest {

    @Test
    fun `Test merge sort works`() {
        val expected = arrayOf(0, 1, 4, 4, 5, 5, 5, 98)
        val input = arrayOf(4, 5, 98, 1, 0, 5, 5, 4)
        MergeSortRecursive()(input)

        assertContentEquals(expected, input)
    }


    // todo: test the stability of the merge sort implementation
}