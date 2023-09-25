package algorithms.search

/***
 * Basic binary search:
 * Places a window from [left] to [right] on the [array].
 * Then compares mid of the window to the search [element].
 * Cuts the window from left or right depending on the comparison.
 * Repeats until window size is 0 or the comparison results in a match.
 *
 * @return index of the [element] or -1 if not found.
 */
fun <E> binarySearch(
    array: Array<E>,
    element: E,
    left: Int = 0,
    right: Int = array.size - 1,
    comparator: Comparator<E>,
): Int {
    var l = left
    var r = right

    while (l <= r) {
        val m = (l + r) / 2
        val cmp = comparator.compare(array[m], element)

        if (cmp < 0) l = m + 1
        else if (cmp > 0) r = m - 1
        else return m
    }
    return -1
}