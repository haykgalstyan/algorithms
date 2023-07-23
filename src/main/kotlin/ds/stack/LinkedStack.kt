package ds.stack

import java.util.*

class LinkedStack<E> : Stack<E> {

    private var head: Node<E>? = null

    override fun push(element: E) {
        head = Node(element, head)
    }

    override fun pop(): E {
        val element = head?.value ?: throw EmptyStackException()
        head = head!!.prev
        return element
    }

    private data class Node<E>(
        val value: E,
        val prev: Node<E>?,
    )
}