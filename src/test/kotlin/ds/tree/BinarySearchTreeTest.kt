package ds.tree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BinarySearchTreeTest {

    private val data = mapOf(
        "Alice" to 123,
        "Bob" to 222,
        "John" to 321,
        "Jane" to 4444,
        "Xavier" to 666,
    )

    private lateinit var bst: BinarySearchTree<String, Int>
    private val comparator = Comparator<String> { o1, o2 -> o1.compareTo(o2) }

    @BeforeEach
    fun setup() {
        bst = BinarySearchTree(comparator)
    }

    @Test
    fun `Test getting inserted data works`() {
        data.onEach { bst.insert(it.key, it.value) }
        data.onEach { assertEquals(it.value, bst.get(it.key)) }
    }

    @Test
    fun `Test deleting works`() {
        data.onEach { bst.insert(it.key, it.value) }
        data.onEach { bst.delete(it.key) }
        data.onEach { assertEquals(null, bst.get(it.key)) }
    }
}