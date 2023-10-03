package ds.graph

/**
 * Nodes are also called vertices in graphs.
 * Edges are the connections of nodes.
 */
interface Graph<T> {

    fun connect(node1: T, node2: T)

    fun getAdjacent(node: T): Set<T>

    fun getNodes(): Set<T>

    fun getEdges(): Set<T>
}