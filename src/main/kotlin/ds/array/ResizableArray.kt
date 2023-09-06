package ds.array

class ResizableArray<E>(initialCapacity: Int) : DynamicArray<E> {

    private var array = Array<Any?>(initialCapacity) {}

    private var pointer = 0


    override fun get(index: Int): E {
        @Suppress("UNCHECKED_CAST")
        return array[index] as E
    }

    override fun set(index: Int, element: E) {
        array[index] = element
    }

    override fun add(element: E) {
        growIfNeeded()

        // todo
    }

    override fun size() = pointer


    private fun growIfNeeded() {
        // todo
    }

    private fun shrinkIfNeeded() {
        // todo
    }
}