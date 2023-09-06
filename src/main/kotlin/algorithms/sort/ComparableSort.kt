package algorithms.sort

/***
 * Sorts an array of comparables
 */
interface ComparableSort {
    fun <T : Comparable<T>> sort(data: Array<T>)
}