package algorithms.sort


fun <T> mergeSort(data: Array<T>): Array<T> {

}


/**
 * Merge [array] consisting of two sorted sub-arrays.
 * [low]..[mid] and ([mid]+1)..[high] must be sorted.
 */
fun <T : Comparable<T>> merge(
    array: Array<T>,
    tempArray: Array<T>,
    low: Int, mid: Int, high: Int,
) {
    // move to temp array
    for (i in low..high) tempArray[i] = array[i]

    // merge back sorted
    var left = low // left side index
    var right = mid + 1 // right side index

    for (i in low..high) {
        // left half is larger, just put from right half
        array[i] = if (left > mid) tempArray[right++]
        // right side is larger, just put from left half
        else if (right > high) tempArray[left++]
        // if left is larger put it first
        else if (tempArray[left] > tempArray[right]) tempArray[left++]
        // at this point right is larger, put it.
        else tempArray[right++]
    }
}