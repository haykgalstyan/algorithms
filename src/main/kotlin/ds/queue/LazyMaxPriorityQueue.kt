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

        val sz = array.size
        var maxIndex = 0
        for (i in array.indices)
            if (comparator.compare(array[i] as E, array[maxIndex] as E) > 0) {
                maxIndex = i
                val end = array[sz - 1]
                array[sz - 1] = array[maxIndex]
                array[maxIndex] = end
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