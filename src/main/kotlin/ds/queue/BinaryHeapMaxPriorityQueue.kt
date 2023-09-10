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
        return array[pointer] as E
    }

    override fun isEmpty() = pointer == 0


    /***
     * Promote the node until heap order is restored.
     *
     * [enqueue] inserts a node at the end possibly causing a violation
     * of heap order, because the node can be larger than the parent.
     * The node needs to be promoted until the heap order is restored.
     */
    @Suppress("UNCHECKED_CAST")
    private fun promoteNode() {
        var i = pointer
        while (
            i > 1 &&
            comparator.compare(array[i] as E, array[i / 2] as E) > 0
        ) {
            val node = array[i] as E
            val parent = array[i / 2] as E
            array[i / 2] = node
            array[i] = parent
            i /= 2
        }
    }

    /***
     * Demote the node until heap order is restored.
     *
     * [enqueue] inserts a node at the end possibly causing a violation
     * of heap order, because the node can be larger than the parent.
     * The node needs to be promoted until the heap order is restored.
     */
    private fun demote(i: Int) {

    }
}