package ds.queue

/**
 * Unordered (lazy) implementation of max priority queue.
 * [enqueue] constant time
 * [dequeue] n
 * [peek] n
 */
@Suppress("UNCHECKED_CAST")
class UnorderedMaxPriorityQueue<E>(
    capacity: Int,
    private val comparator: Comparator<E>
) : Queue<E> {

    private var array = Array<Any?>(capacity) {}
    private var pointer = 0

    override fun enqueue(element: E) {
        array[pointer++] = element
    }

    override fun dequeue(): E {
        if (isEmpty()) throw NoSuchElementException()

        moveMaxToEnd()
        return array[--pointer] as E
    }

    override fun peek(): E {
        moveMaxToEnd()
        return array[pointer] as E
    }

    override fun isEmpty() = pointer == 0


    private fun moveMaxToEnd() {
        // find index of max
        var max = 0
        for (i in 1..<pointer)
            if (comparator.compare(array[i] as E, array[max] as E) > 0) max = i

        // move max to the end
        val oldMax = array[pointer - 1]
        array[pointer - 1] = array[max]
        array[max] = oldMax
    }
}