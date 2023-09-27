package ds.tree

import java.util.TreeSet

/**
 * @see [TreeMap] and [TreeSet] for java collection implementations.
 */
class RedBlackBinarySearchTree<K, V>(
    val comparator: Comparator<K>,
    private var root: BinarySearchTree.Node<K, V>? = null,
) : Tree<K, V> {

    override fun insert(key: K, value: V) {
        TODO("Not yet implemented")
    }

    override fun get(key: K): V? {
        TODO("Not yet implemented")
    }

    override fun delete(key: K) {
        TODO("Not yet implemented")
    }
}