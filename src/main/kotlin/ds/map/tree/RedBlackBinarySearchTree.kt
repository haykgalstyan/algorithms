package ds.map.tree

import ds.map.Map
import java.util.*

/**
 * The self-balancing variant of [BinarySearchTree]
 *
 * @see [TreeMap] and [TreeSet] for java collection implementations.
 */
class RedBlackBinarySearchTree<K, V>(
    val comparator: Comparator<K>,
    private var root: BinarySearchTree.Node<K, V>? = null,
) : Map<K, V> {

    override fun put(key: K, value: V) {
        TODO("Not yet implemented")
    }

    override fun get(key: K): V? {
        TODO("Not yet implemented")
    }

    override fun delete(key: K) {
        TODO("Not yet implemented")
    }

    override fun contains(key: K): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }
}