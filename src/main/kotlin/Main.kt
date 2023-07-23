import data.Strings
import ds.stack.LinkedStack
import ds.stack.ResizableArrayStack
import ds.stack.Stack
import java.util.*
import kotlin.system.measureTimeMillis


const val string_length = 5
const val strings = 1_000_000
const val tests = 1000

fun main(args: Array<String>) {

    val data = Strings.strings(strings, string_length)
    println("Generated $strings strings.")

    var linkedTotal = 0L
    var arrayTotal = 0L
    repeat(tests) {
        ResizableArrayStack<String>().test(data).also { arrayTotal += it }
        LinkedStack<String>().test(data).also { linkedTotal += it }
        print(".")
    }
    println()
    println("Linked average: ${linkedTotal / tests}")
    println("Array average: ${arrayTotal / tests}")
}


private fun <T> Stack<T>.test(data: Array<T>): Long {
    val time = measureTimeMillis {
        pushAll(data)
        popAll()
    }
    return time
}


private fun <T> Stack<T>.pushAll(strings: Array<T>) =
    strings.forEach { push(it) }

private fun <T> Stack<T>.popAll() = try {
    while (true) pop()
} catch (e: EmptyStackException) {
    // done
}