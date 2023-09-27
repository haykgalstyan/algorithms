package algorithms.sort

/**
 * Sorts an array of comparables
 */
interface ComparableSort {
    operator fun <T : Comparable<T>> invoke(data: Array<T>)
}