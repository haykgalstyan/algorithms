package algorithms.sort.mergesort

import algorithms.sort.ComparableSort
import kotlin.math.min


/**
 * Bottom up non-recursive merge sort implementation.
 * This version is simpler, but about 10% slower than recursive,
 * top-down mergesort on typical systems.
 * It was as fast as the recursive version on my tests though :)
 */
class MergeSortBottomUp : ComparableSort {

    override fun <T : Comparable<T>> invoke(data: Array<T>) {
        // create an empty array of T. I know, it looks disgusting...
        @Suppress("UNCHECKED_CAST")
        val tempArray: Array<T> =
            Array<Comparable<Any>?>(data.size) { null } as Array<T>

        var size = 1
        while (size < data.size) {
            var low = 0
            while (low < data.size - size) {
                merge(
                    data,
                    tempArray,
                    low,
                    low + size - 1,
                    min(low + size + size - 1, data.size - 1)
                )
                low += size + size
            }
            size += size
        }
    }


    /**
     * Merge [array] consisting of two sorted sub-arrays.
     * [low]..[mid] and ([mid]+1)..[high] must be sorted.
     */
    private fun <T : Comparable<T>> merge(
        array: Array<T>,
        tempArray: Array<T>,
        low: Int, mid: Int, high: Int,
    ) {
        // move to temp array
        for (i in low..high) tempArray[i] = array[i]

        // merge back sorted
        var left = low // index in left half
        var right = mid + 1 // index in right half
        for (i in low..high) array[i] =
                // left half is done, nothing to compare, just put from right half
            if (left > mid) tempArray[right++]
            // right half is done, nothing to compare, just put from left half
            else if (right > high) tempArray[left++]
            // if left is smaller put it first
            else if (tempArray[left] < tempArray[right]) tempArray[left++]
            // else put right.
            else tempArray[right++]
    }
}