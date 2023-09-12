package ds.queue


class LinkedQueue<E>(capacity: Int) : Queue<E> {

    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    override fun enqueue(element: E) {
        TODO()
    }

    override fun dequeue(): E {
        if (isEmpty()) throw NoSuchElementException()

        TODO()
    }

    override fun peek(): E {
        TODO()
    }

    override fun isEmpty() = TODO()


    private data class Node<E>(
        val value: E,
        val prev: Node<E>?,
    )
}