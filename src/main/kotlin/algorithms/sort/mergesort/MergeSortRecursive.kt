package algorithms.sort.mergesort

import algorithms.sort.ComparableSort


/**
 * Classic merge sort implementation, recursive and non-optimized.
 *
 * Merge sort recursively divides an array into halves until there are single elements in each,
 * then performs merging while also sorting the elements.
 * The second step is separated into two steps of its own, where first
 * all elements are copied into an auxiliary array and then
 * merged (while sorted) into the original array [data].
 *
 * (Dividing and merge-sorting are done in-place, using indexes for ranges rather than creating new arrays.)
 *
 * 1. Recursively divide array into halves.
 * 2. Recursively merge back while sorting the halves:
 *    a: Copy array into the auxiliary array.
 *    b: Merge back into original array while comparing and sorting.
 *
 * There are optimisations that can be made:
 * - Don't merge if already sorted. When largest item in left half is smaller than smaller item on the right half.
 * - Don't copy into auxiliary array, instead switch the roles of the arrays, so that the second one is auxiliary.
 */
class MergeSortRecursive : ComparableSort {

    override fun <T : Comparable<T>> invoke(data: Array<T>) {
        // create an empty array of T. I know, it looks disgusting...
        @Suppress("UNCHECKED_CAST")
        val tempArray: Array<T> =
            Array<Comparable<Any>?>(data.size) { null } as Array<T>
        sort(data, tempArray, 0, data.size - 1)
    }

    /**
     * Recursively divide and sort the [low]..[high] range of [array]
     */
    private fun <T : Comparable<T>> sort(
        array: Array<T>,
        tempArray: Array<T>,
        low: Int, high: Int,
    ) {
        if (high <= low) return
        // find the mid
        val mid = low + (high - low) / 2
        // sort left half recursively
        sort(array, tempArray, low, mid)
        // sort right half recursively
        sort(array, tempArray, mid + 1, high)
        // merge the sorted halves
        merge(array, tempArray, low, mid, high)
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