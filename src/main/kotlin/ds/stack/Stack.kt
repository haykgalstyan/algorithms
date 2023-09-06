package ds.stack

import java.util.*

interface Stack<E> {

    fun push(element: E)

    /**
     * throws [EmptyStackException] if the stack is empty
     */
    fun pop(): E

    /**
     * throws [EmptyStackException] if the stack is empty
     */
    fun peek(): E

    fun isEmpty(): Boolean
}