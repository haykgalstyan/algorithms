package ds.tree


/**
 * Binary search tree (BST) is a rooted binary tree where
 * the key of each internal node is
 * larger than all the keys in its left subtree
 * and smaller than all the ones in its right subtree.
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
 * @see [delete] for some details on worst case performance.
 * @see [RedBlackBinarySearchTree] for a guarantee O(log n performance for all operations)
 *
 * This implementation uses only [Comparator]
 * for the comparison and sorting of the keys for versatility.
 * Another implementation could accept only [Comparable] keys, or combine both.
 *
 * An example of a BST:
 *          (8)
 *         /   \
 *       (3)  (10)
 *      /  \     \
 *    (1)  (6)   (14)
 *        /  \    /
 *      (4) (7) (13)
 *
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

        // search for the key node to update
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

    /**
     * Binary search for the [key]
     */
    override fun get(key: K): V? {
        var node = root
        while (node != null) {
            val cmp = comparator.compare(key, node.key)
            // key is smaller, go deeper to left
            if (cmp < 0) node = node.left
            // key is larger, go deeper to right
            else if (cmp > 0) node = node.right
            // found the key, return it
            else return node.value
        }
        return null
    }

    override fun delete(key: K) {
        root = delete(key, root)
    }

    /**
     * Hibbard deletion algorithm:
     * 1. Find the [node] to delete:
     *    A) [node] has no children, just return null.
     *    B) [node] has a single child, return the child node to be replaced.
     *    C) [node] has two children:
     *       1. Find the next smallest node in its right subtree.
     *       2. Swap that smallest node with the current [node].
     *       2. Delete the node.
     *
     * NOTE: It was discovered later that the lack of symmetry in this algorithm
     * (picking the right), even when inserting and deleting random keys
     * results in an unbalancing of the tree to the left.
     * This degrades the BST performance closer to the worst case. (sqrt n)
     * Randomly picking right or left does not fix this problem. (why?)
     * It's a standing problem, to find a natural, simple and efficient delete
     * algorithm for the BST.
     *
     * @see [RedBlackBinarySearchTree] which is much better in this regard.
     */
    private fun delete(key: K, node: Node<K, V>?): Node<K, V>? {
        var resultNode = node ?: return null

        // search for the key node to delete
        val cmp = comparator.compare(key, resultNode.key)
        if (cmp < 0) // key is smaller, go deeper to left
            resultNode.left = delete(key, resultNode.left)
        else if (cmp > 0) // key is larger, go deeper to right
            resultNode.right = delete(key, resultNode.right)
        else { // key found, delete in a way depending on child count
            if (resultNode.right == null) return resultNode.left // has only left, return it
            if (resultNode.left == null) return resultNode.right // has only right, return it

            // has both children
            val n = resultNode
            // find the next smallest node to right
            resultNode = min(n.right!!)!!
            // delete the smallest node and fix the links
            resultNode.right = deleteMin(n.right!!)
            resultNode.left = n.left
        }
        return resultNode
    }

    /**
     * This will be useful for the [delete] operation
     * To find the min go left until the node has no left node.
     */
    private fun min(node: Node<K, V>): Node<K, V>? {
        if (node.left == null) return node
        return min(node.left!!)
    }

    /**
     * This will be useful for the [delete] operation
     * 1. To find the min go left until the node has no left node.
     * 2. Replace the node by its right node.
     */
    private fun deleteMin(node: Node<K, V>): Node<K, V>? {
        if (node.left == null) return node.right
        node.left = deleteMin(node.left!!)
        return node
    }
}