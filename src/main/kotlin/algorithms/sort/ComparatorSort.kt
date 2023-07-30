package algorithms.sort

/***
 * Sorts and array of objects via provided comparator
 */
interface ComparatorSort {
    fun <T> sort(data: Array<T>, comparator: Comparator<T>)
}