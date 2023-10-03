package algorithms.search

import ds.graph.TestGraph
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DepthFirstSearchKtTest {

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

    @Test
    fun dfsRTest() {
        val adjacentProvider = { n: String -> testGraph.getAdjacent(n) }

        val result = HashSet<String>()

        dfsR("x", result, adjacentProvider)
        assertEquals(5, result.size)
        result.onEach { assert(it.startsWith("x")) }
        result.clear()

        dfsR("o", result, adjacentProvider)
        assertEquals(5, result.size)
        result.onEach { assert(it.startsWith("o")) }
    }

    @Test
    fun dfsITest() {
        val adjacentProvider = { n: String ->
            testGraph.getAdjacent(n).toList()
        }

        dfsI("x", adjacentProvider).let {
            assertEquals(5, it.size)
            it.onEach { n -> assert(n.startsWith("x")) }
        }

        dfsI("o", adjacentProvider).let {
            assertEquals(5, it.size)
            it.onEach { n -> assert(n.startsWith("o")) }
        }
    }

    @Test
    fun dfsISetsTest() {
        val adjacentProvider = { n: String ->
            testGraph.getAdjacent(n)
        }

        dfsISets(setOf("x"), adjacentProvider).let {
            assertEquals(5, it.size)
            it.onEach { n -> assert(n.startsWith("x")) }
        }

        dfsISets(setOf("o"), adjacentProvider).let {
            assertEquals(5, it.size)
            it.onEach { n -> assert(n.startsWith("o")) }
        }

        assertEquals(10, dfsISets(setOf("x", "o"), adjacentProvider).size)
    }
}