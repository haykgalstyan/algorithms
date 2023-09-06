import algorithms.sort.mergesort.MergeSortBottomUp
import algorithms.sort.mergesort.MergeSortRecursive
import data.DataRepository
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val dataCount = 10_000_000
    val runs = 100

    var timeTotalRecursive = 0L
    var timeTotalNonRecursive = 0L
    repeat(runs) {
        val nonRecursiveTime = measureTimeMillis {
            MergeSortBottomUp()(DataRepository.getNumbers(count = dataCount))
        }
        timeTotalNonRecursive += nonRecursiveTime

        val recursiveTime = measureTimeMillis {
            MergeSortRecursive()(DataRepository.getNumbers(count = dataCount))
        }
        timeTotalRecursive += recursiveTime
    }
    val averageTimeRecursive = timeTotalRecursive / runs
    val averageTimeNonRecursive = timeTotalNonRecursive / runs
    println("MergeSort R, averageTime: $averageTimeRecursive")
    println("MergeSort NR, averageTime: $averageTimeNonRecursive")
}
