package algorithms.graph

import ds.graph.TestGraph
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DfsRKtTest {

    private val testGraph = TestGraph(
        edges = hashMapOf(
            "x" to setOf("x", "xx"),
            "xx" to setOf("x", "xx", "xxx"),
            "xxx" to setOf("x", "xx", "xxx", "xxxx"),
            "xxxx" to setOf("x", "xx", "xxx", "xxxx", "xxxxx"),
            "o" to setOf("o", "oo"),
            "oo" to setOf("o", "oo", "ooo"),
            "ooo" to setOf("o", "oo", "ooo", "oooo"),
            "oooo" to setOf("o", "oo", "ooo", "oooo", "ooooo"),
        )
    )

    private val adjacentProvider = { n: String -> testGraph.getAdjacent(n) }

    @Test
    fun `test correct nodes are found`() {
        val result = HashSet<String>()
        dfsR("x", result, adjacentProvider)

        assertEquals(5, result.size)
        result.onEach { assert(it.startsWith("x")) }
    }
}