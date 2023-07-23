package ds.stack

import java.util.*

interface Stack<E> {

    fun push(element: E)

    @Throws(EmptyStackException::class)
    fun pop(): E
}