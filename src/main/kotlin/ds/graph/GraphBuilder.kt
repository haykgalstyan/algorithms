package ds.graph

class GraphBuilder<T> {
    private val nodes = HashSet<T>()
    private val edges = HashMap<T, HashSet<T>>()

    /**
     * Add a node if not already present
     */
    fun addNode(node: T) {
        if (!nodes.contains(node)) {
            nodes.add(node)
        }
        nodes.add(node)
        edges.computeIfAbsent(node) { HashSet() }
    }

    /**
     * Add two nodes and connect them
     */
    fun addEdge(n1: T, n2: T) {
        nodes.add(n1)
        nodes.add(n2)
        connect(n1, n2)
    }

    /**
     * Connect already added nodes
     */
    fun connect(n1: T, n2: T) {
        edges[n1]!!.add(n2)
    }

    fun build(): Graph<T> = object : Graph<T> {
        // temp solution till graph implemented
        override fun getAdjacent(node: T) = edges[node]!!
        override fun getNodes() = nodes
    }
}