package ds.queue

class BinaryHeapMaxPriorityQueue<E>(
    capacity: Int,
    private val comparator: Comparator<E>,
) : Queue<E> {

    private var array = Array<Any?>(capacity) {}
    private var pointer = 0


    override fun enqueue(element: E) {
        this[++pointer] = element
        promoteNode()
    }

    override fun dequeue(): E {
        if (isEmpty()) throw NoSuchElementException()

        val e = this[1]
        swap(1, pointer--)
        demote()
        this[pointer + 1] = null
        return e
    }

    override fun peek(): E {
        return this[pointer]
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
        while (i > 1 && comparator.compare(this[i], this[i / 2]) > 0) {
            val node = this[i]
            val parent = this[i / 2]
            this[i / 2] = node
            this[i] = parent
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
        var k = 1

        while (2 * k <= pointer) {
            // pick the (smaller? larger?) child
            var j = 2 * k
            if (j < pointer && comparator.compare(this[j], this[j + 1]) < 0) j++

            // check if done
            if (comparator.compare(this[k], this[k]) > 0) break

            swap(k, j)

            k = j
        }
    }

    @Suppress("UNCHECKED_CAST")
    private operator fun get(index: Int) = array[index] as E
    private operator fun set(index: Int, element: E?) {
        array[index] = element
    }

    private fun swap(a: Int, b: Int) {
        val aa = this[a]
        this[a] = this[b]
        this[b] = aa
    }
}