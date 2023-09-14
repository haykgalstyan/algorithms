package algorithms.sort

/***
 * Sorts and array of objects via provided comparator
 */
interface ComparatorSort {
    operator fun <T> invoke(data: Array<T>, comparator: Comparator<T>)
}