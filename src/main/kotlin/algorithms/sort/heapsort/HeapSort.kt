package algorithms.sort.heapsort

import algorithms.sort.ComparatorSort

/***
 * In-place heap sort
 * 0. Start with unsorted nodes.
 * 1. Sort the nodes into a max-heap array in-place so that every node is larger than its children.
 * 2. Repeatedly remove the max element
 */
class HeapSort : ComparatorSort {
    override operator fun <T> invoke(
        data: Array<T>,
        comparator: Comparator<T>
    ) {

    }
}