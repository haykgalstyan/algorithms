import ds.stack.LinkedStack
import ds.stack.ResizableArrayStack
import ds.stack.Stack
import java.util.*
import kotlin.system.measureTimeMillis


data class Config(val testsCount: Int)

class StackDemo(
    private val data: Array<Any>,
    private val config: Config,
) {

    private val testCount = config.testsCount

    fun run() {
        var linkedTotal = 0L
        var arrayTotal = 0L
        repeat(testCount) {
            ResizableArrayStack<Any>().test(data).also { arrayTotal += it }
            LinkedStack<Any>().test(data).also { linkedTotal += it }
            print(".")
        }
        println()
        println("Linked average: ${linkedTotal / testCount}")
        println("Array average: ${arrayTotal / testCount}")
    }
}


private fun <T> Stack<T>.test(data: Array<T>): Long {
    val time = measureTimeMillis {
        pushAll(data)
        popAll()
    }
    return time
}

private fun <T> Stack<T>.pushAll(arr: Array<T>) = arr.forEach { push(it) }

private fun <T> Stack<T>.popAll() = try {
    while (true) pop()
} catch (ignored: EmptyStackException) {
}