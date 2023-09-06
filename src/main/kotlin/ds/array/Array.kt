package ds.array


interface Array<E> {

    fun get(index: Int): E

    fun set(index: Int, element: E)

    fun size(): Int
}