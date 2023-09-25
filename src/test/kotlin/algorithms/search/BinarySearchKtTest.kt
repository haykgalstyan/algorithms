package algorithms.search

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinarySearchKtTest {

    private val sortedInput = arrayOf(
        "A", "B", "C", "D", "E", "F", "G",
    )

    private val comparator = compareBy<String> { it }

    @Test
    fun `Test search works`() {
        val expected = 3
        val search = "D"
        val actual = binarySearch(sortedInput, search, comparator = comparator)

        assertEquals(expected, actual)
    }

    @Test
    fun `Test not found returns invalid index`() {
        val expected = -1
        val search = "H"
        val actual = binarySearch(sortedInput, search, comparator = comparator)

        assertEquals(expected, actual)
    }
}