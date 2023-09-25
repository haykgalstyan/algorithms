package algorithms.search

fun <E> Array<E>.binarySearch(
    element: E,
    start: Int = 0,
    end: Int = size - 1,
    comparator: Comparator<E>,
) {

    var l = start
    var r = end

    while (l <= r) {
        val m = (l + r) / 2
        val mm = this[m]

        when (comparator.compare(mm, element)) {
            1 ->
        }
    }
}