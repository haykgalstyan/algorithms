package ds.graph


interface MutableGraph<T>: Graph<T> {

    /**
     * Add a node if not already present
     */
    fun addNode(node: T)

    /**
     * Add two nodes and connect them
     */
    fun addEdge(n1: T, n2: T)

    /**
     * Connect already added nodes
     */
    fun connect(n1: T, n2: T)
}