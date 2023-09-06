package ds.stack

import java.util.*


class ResizableArrayStack<E>(initialCapacity: Int = 10) : Stack<E> {

    private var array = Array<Any?>(initialCapacity) {}
    private var pointer = 0

    override fun push(element: E) {
        // move to a 2x bigger array if this one is full
        if (pointer == array.size) {
            val newArray = Array<Any?>(array.size * 2) {}
            for (i in array.indices) newArray[i] = array[i]
            array = newArray
        }

        array[pointer++] = element
    }


    override fun pop(): E {
        if (pointer == 0) {
            throw EmptyStackException()
        }
        // move to a 2x smaller array if this one is only 1/4 full
        if (pointer == array.size / 4) {
            val newArray = Array<Any?>(array.size / 2) {}
            for (i in newArray.indices) newArray[i] = array[i]
            array = newArray
        }

        @Suppress("UNCHECKED_CAST")
        return array[--pointer] as E
    }

    override fun peek(): E {
        if (pointer == 0) {
            throw EmptyStackException()
        }

        @Suppress("UNCHECKED_CAST")
        return array[pointer] as E
    }

    override fun isEmpty() = pointer == 0
}