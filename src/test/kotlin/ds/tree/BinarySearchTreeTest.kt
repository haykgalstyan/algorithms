package ds.tree

import ds.map.tree.BinarySearchTree
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BinarySearchTreeTest {

    private val input = mapOf(
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
    fun `Test put and get work`() {
        input.onEach { bst.put(it.key, it.value) }
        input.onEach { assertEquals(it.value, bst.get(it.key)) }
    }

    @Test
    fun `Test delete works`() {
        input.onEach { bst.put(it.key, it.value) }
        input.onEach { bst.delete(it.key) }
        input.onEach { assertEquals(null, bst.get(it.key)) }
    }

    @Test
    fun `Test contains works`() {
        input.onEach { assertEquals(false, bst.contains(it.key)) }
        input.onEach { bst.put(it.key, it.value) }
        input.onEach { assertEquals(true, bst.contains(it.key)) }
    }

    @Test
    fun `Test isEmpty works`() {
        input.onEach { bst.put(it.key, it.value) }
        input.onEach { bst.delete(it.key) }
        assert(bst.isEmpty())
    }
}