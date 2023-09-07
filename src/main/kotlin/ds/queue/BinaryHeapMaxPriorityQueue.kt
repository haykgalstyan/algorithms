package ds.queue

class BinaryHeapMaxPriorityQueue<E>(
    capacity: Int,
    private val comparator: Comparator<E>,
) : Queue<E> {

    private var array = Array<Any?>(capacity) {}
    private var pointer = 0


    override fun enqueue(element: E) {
        TODO("Not yet implemented")
    }

    override fun dequeue(): E {
        TODO("Not yet implemented")
    }

    override fun peek(): E {
        return array[pointer] as E
    }

    override fun isEmpty() = pointer == 0


    private fun promote(i: Int) {
        while (i > 1 && comparator.compare(i / 2, i)) {

        }
    }

    private fun demote(i: Int) {

    }
}