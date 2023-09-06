package ds.queue

import kotlin.NoSuchElementException

class LazyMaxPriorityQueue<E>(
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

        val size = array.size
        var max: E? = null
        for (i in array.indices) {
            val e = array[i] as E

            if (max == null || comparator.compare(e, max) > 0) {
                max = e
                // move element to the end
                array[i] = array[size - 1]
                array[size - 1] = max
            }
        }

        @Suppress("UNCHECKED_CAST")
        return array[--pointer] as E
    }

    override fun peek(): E {
        @Suppress("UNCHECKED_CAST")
        return array[pointer] as E
    }

    override fun isEmpty() = pointer == 0
}