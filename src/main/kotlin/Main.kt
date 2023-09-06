import ds.queue.LazyMaxPriorityQueue

fun main(args: Array<String>) {

    val size = 5
    var queue = LazyMaxPriorityQueue(
        size,
        Comparator<Int> { o1, o2 -> o1.compareTo(o2) }
    )

    repeat(size) {
        queue.enqueue(it)
    }
    repeat(size) {
        queue.dequeue()
    }
}
