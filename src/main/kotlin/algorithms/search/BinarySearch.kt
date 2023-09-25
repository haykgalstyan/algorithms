package algorithms.search

/***
 * Basic binary search:
 * Places a window of left and right indices on the [array].
 * Then compares mid of the window to the search [element].
 * Cuts the window from left or right depending on the comparison.
 * Repeats until window size is 0 or the comparison results in a match.
 */
fun <E> binarySearch(
    array: Array<E>,
    element: E,
    start: Int = 0,
    end: Int = array.size - 1,
    comparator: Comparator<E>,
): Int {
    var l = start
    var r = end

    while (l <= r) {
        val m = (l + r) / 2
        val cmp = comparator.compare(array[m], element)

        if (cmp < 0) l = m + 1
        else if (cmp > 0) r = m - 1
        else return m
    }
    return -1
}