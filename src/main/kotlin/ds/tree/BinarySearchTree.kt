package ds.tree


/***
 * Binary search tree (BST, ordered or sorted binary tree) is a rooted binary tree
 * where the key of each internal node is larger than the keys in its left subtree
 * and smaller than the ones in its right subtree.
 *
 * Binary search trees allow binary search for fast lookup, addition, and removal.
 * Since the nodes in a BST are laid out so that each comparison
 * skips about half of the remaining tree, the lookup performance is proportional
 * to that of binary logarithm (log n).
 *
 * Number of compares for [insert] and [get] is 1 + node depth.
 *
 * Big O chart:
 * Algorithm:	Average:    Worst case:
 * Space	    O(n)        O(n)
 * Search	    O(log n)	O(n)
 * Insert	    O(log n)	O(n)
 * Delete	    O(log n)	O(n)
 *
 * This implementation uses only [Comparator]
 * for the comparison and sorting of the keys for versatility.
 * Another implementation could accept only [Comparable] keys, or combine both.
 */
class BinarySearchTree<K, V>(
    val comparator: Comparator<K>,
    private var root: Node<K, V>? = null,
) : Tree<K, V> {

    data class Node<K, V>(
        val key: K,
        var value: V,
        var left: Node<K, V>? = null,
        var right: Node<K, V>? = null,
    )

    override fun insert(key: K, value: V) {
        root = insert(key, value, root)
    }

    private fun insert(
        key: K,
        value: V,
        node: Node<K, V>?
    ): Node<K, V> {
        // key not in the tree.
        // either reached the bottom recursively or this is the first node
        // return a newly created node.
        if (node == null) return Node(key, value)

        val cmp = comparator.compare(key, node.key)
        if (cmp < 0) // key is smaller, go deeper to left
            node.left = insert(key, value, node.left)
        else if (cmp > 0) // key is larger, go deeper to right
            node.right = insert(key, value, node.right)
        else // key found in the tree, update the value
            node.value = value

        // this will be the root in the outermost recursive call
        return node
    }

    override fun get(key: K): V? {
        var node = root
        while (node != null) {
            val cmp = comparator.compare(key, node.key)
            if (cmp < 0) node = node.left
            else if (cmp > 0) node = node.right
            else return node.value
        }
        return null
    }

    override fun delete(key: K) {
        TODO("Not yet implemented")
    }
}