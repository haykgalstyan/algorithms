package ds.queue


interface Queue<E> {

    fun enqueue(element: E)

    fun dequeue(): E

    fun peek(): E

    fun isEmpty(): Boolean
}