package algorithms.graph

import ds.graph.TestGraph
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BfsShortestPathKtTest {

    private val testGraph = TestGraph(
        edges = hashMapOf(
            "a" to setOf("b", "g"),
            "b" to setOf("c", "a"),
            "c" to setOf("d", "b"),
            "d" to setOf("e", "c"),
            "e" to setOf("f", "d"),
            "f" to setOf("g", "e"),
            "g" to setOf("a", "f"),
        )
    )

    private val adjacentProvider = { n: String ->
        testGraph.getAdjacent(n).toList()
    }

    @Test
    fun `test shortest path is found`() {
        val result = bfs("a", "g", adjacentProvider)

        assertEquals(5, result.size)
        result.onEach { n -> assert(n.startsWith("x")) }
    }
}