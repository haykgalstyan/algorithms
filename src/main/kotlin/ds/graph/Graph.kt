package ds.graph

/**
 * Nodes are also called vertices in graphs.
 * Edges are the connections of nodes.
 */
interface Graph {

    fun connect(node1: Int, node2: Int)

    fun getAdjacent(node: Int): Iterable<Int>

    fun getNodes(): Int

    fun getEdges(): Int
}