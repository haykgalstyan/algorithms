package ds.queue

class BinaryHeapMaxPriorityQueue<E>(
    capacity: Int,
    private val comparator: Comparator<E>,
) : Queue<E> {

    private var array = Array<Any?>(capacity) {}
    private var pointer = 0


    override fun enqueue(element: E) {
        array[++pointer] = element
        promoteNode()
    }

    override fun dequeue(): E {
        TODO("Not yet implemented")
    }

    override fun peek(): E {
        return get(pointer)
    }

    override fun isEmpty() = pointer == 0


    /***
     * Promote the node until heap order is restored.
     *
     * [enqueue] inserts a node at the end possibly causing a violation
     * of heap order, because the node can be larger than the parent.
     * The node needs to be promoted until the heap order is restored.
     * (Bottom-up reheapification)
     */
    private fun promoteNode() {
        var i = pointer
        while (i > 1 && comparator.compare(get(i), get(i / 2)) > 0) {
            val node = get(i)
            val parent = get(i / 2)
            array[i / 2] = node
            array[i] = parent
            i /= 2
        }
    }

    /***
     * Demote the node until heap order is restored.
     *
     * [dequeue] exchanges the priority element with the end node and drops it
     * causing a violation of heap order, because the node can be smaller than
     * its child(ren).
     * The node needs to be demoted until the heap order is restored.
     * (Top-down reheapification)
     */
    private fun demote() {
        var k = pointer

        while (2 * k <= pointer) {

            // pick the (smaller? larger?) child
            var j = 2 * k
            if (j < pointer && comparator.compare(get(j), get(j + 1)) < 0) j++

            // check if done
            if (comparator.compare(get(k), get(j)) > 0) break

            // exchange k with j
            // todo

            k = j
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun get(index: Int) = array[index] as E
}