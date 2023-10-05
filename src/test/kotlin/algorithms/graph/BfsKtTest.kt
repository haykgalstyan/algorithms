package algorithms.graph

import ds.graph.TestGraph
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BfsKtTest {

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
    fun `test correct nodes are found`() {
        val result = bfs("x", adjacentProvider)

        assertEquals(5, result.size)
        result.onEach { n -> assert(n.startsWith("x")) }
    }
}