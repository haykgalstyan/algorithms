package ds.stack

import java.util.*

class ArrayStack<E>(capacity: Int) : Stack<E> {

    private var array = Array<Any?>(capacity) { null }
    private var pointer = 0

    override fun push(element: E) {
        array[pointer++] = element
    }

    override fun pop(): E {
        if (pointer == 0) {
            throw EmptyStackException()
        }

        @Suppress("UNCHECKED_CAST")
        return array[--pointer] as E
    }
}