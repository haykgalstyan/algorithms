package ds.stack

import java.util.*

interface Stack<E> {

    fun push(element: E)

    /**
     * throws [EmptyStackException] if the stack is empty
     */
    fun pop(): E

    val isEmpty: Boolean
}