package ds.queue

import java.util.*
import kotlin.NoSuchElementException

class ArrayQueue<E>(capacity: Int) : Queue<E> {

    private var array = Array<Any?>(capacity) {}
    private var start = 0
    private var end = 0

    override fun enqueue(element: E) {
        array[end++] = element
    }

    override fun dequeue(): E {
        if (isEmpty()) throw NoSuchElementException()

        @Suppress("UNCHECKED_CAST")
        return array[start++] as E
    }

    override fun peek(): E {
        @Suppress("UNCHECKED_CAST")
        return array[start] as E
    }

    override fun isEmpty() = end == 0
}