package ds.stack

import java.util.*

class LinkedStack<E> : Stack<E> {

    private var head: Node<E>? = null

    override fun push(element: E) {
        head = Node(element, head)
    }

    override fun pop(): E {
        if (isEmpty()) throw EmptyStackException()

        val localHead = head!!
        head = localHead.prev
        return localHead.value
    }

    override fun peek(): E {
        if (isEmpty()) throw EmptyStackException()

        return head!!.value
    }

    override fun isEmpty() = head == null


    private data class Node<E>(
        val value: E,
        val prev: Node<E>?,
    )
}