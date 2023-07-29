import algorithms.sort.mergeSort
import data.DataRepository

fun main(args: Array<String>) {

    println("Merge sort start")
    val data = DataRepository.getNumbers(count = 9, roof = 5)
    println("Data to sort: ${data.joinToString()}")
    mergeSort(data)
    println("Data after sort: ${data.joinToString()}")
    println("Merge sort end")
}
