package ds.queue


interface Queue<E> {

    fun enqueue(element: E)

    /**
     * Throws [NoSuchElementException] if empty
     */
    fun dequeue(): E

    fun peek(): E

    fun isEmpty(): Boolean
}