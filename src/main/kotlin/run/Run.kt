package run

import algorithms.sort.mergesort.MergeSortBottomUp
import algorithms.sort.mergesort.MergeSortRecursive
import data.DataRepository
import kotlin.system.measureTimeMillis

fun runCompareSortMerge() {
    val dataCount = 1_000_000
    val runs = 100

    var timeTotalRecursive = 0L
    var timeTotalNonRecursive = 0L
    repeat(runs) {
        val recursiveTime = measureTimeMillis {
            MergeSortRecursive().sort(DataRepository.getNumbers(count = dataCount))
        }
        timeTotalRecursive += recursiveTime

        val nonRecursiveTime = measureTimeMillis {
            MergeSortBottomUp().sort(DataRepository.getNumbers(count = dataCount))
        }
        timeTotalNonRecursive += nonRecursiveTime
    }
    val averageTimeRecursive = timeTotalRecursive / runs
    val averageTimeNonRecursive = timeTotalNonRecursive / runs
    println("MergeSort R, averageTime: $averageTimeRecursive")
    println("MergeSort NR, averageTime: $averageTimeNonRecursive")
}

