package ds.graph


interface MutableGraph<T>: Graph<T> {

    fun connect(node1: Int, node2: Int)
}