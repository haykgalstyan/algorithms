package ds.graph

class TestGraph(
    private val edges: Map<String, Set<String>>,
) : Graph<String> {

    private val nodes: Set<String> = edges.keys

    override fun getAdjacent(node: String) = edges[node] ?: emptySet()

    override fun getNodes() = nodes
}