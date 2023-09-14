package algorithms.sort.mergesort

import algorithms.sort.ComparableSort

// todo: in progress
/**
 * Classic recursive merge sort, but with the following optimizations:
 * 1. Don't merge if already sorted. When largest item in left half is smaller than smaller item on the right half.
 * Todo: 2. Don't copy into auxiliary array, instead switch the roles of the arrays, so that the second one is auxiliary.
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
 */
class MergeSortRecursiveOptimized : ComparableSort {

    override operator fun <T : Comparable<T>> invoke(data: Array<T>) {
        // create an empty array of T. I know, it looks disgusting...
        @Suppress("UNCHECKED_CAST")
        val tempArray: Array<T> =
            Array<Comparable<Any>?>(data.size) { null } as Array<T>

        // Start of optimization 2.
        for (i in data.indices) tempArray[i] = data[i]

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

        // The first optimization, which helps with partially sorted arrays.
        // Since at this point the halves are sorted, we can easily check
        // if the whole array is already sorted by comparing last element on the left
        // to the first element on the right and skip the merge if so.
        if (array[mid] < array[mid + 1]) return

        // todo: switch temp and array for their roles as aux
        // merge the sorted halves
        merge(array, tempArray, low, mid, high)
    }


    /**
     * Merge [src] consisting of two sorted sub-arrays into [dst]
     * [low]..[mid] and ([mid]+1)..[high] must be sorted.
     *
     * Instead of first copying into a temporary array and merging back
     * like the classic unoptimized version, this version treats the arrays as
     * source and destination and always merges one into the other.
     *
     * @param src the source Array.
     * @param dst the destination Array.
     */
    private fun <T : Comparable<T>> merge(
        src: Array<T>,
        dst: Array<T>,
        low: Int, mid: Int, high: Int,
    ) {
        var left = low // index in left half
        var right = mid + 1 // index in right half
        for (i in low..high) dst[i] =
                // left half is done, nothing to compare, just put from right half
            if (left > mid) src[right++]
            // right half is done, nothing to compare, just put from left half
            else if (right > high) src[left++]
            // if left is smaller put it first
            else if (src[left] < src[right]) src[left++]
            // else put right.
            else src[right++]
    }
}