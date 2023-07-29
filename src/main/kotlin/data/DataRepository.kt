package data

import kotlin.random.Random

object DataRepository {

    private val chars = ('A'..'Z') + ('a'..'z')
    private val charDigits = ('0'..'9')

    fun getSentence(
        count: Int = 10,
        size: Int = 5,
    ) = Array(count) { getWord(size) }

    fun getWord(
        size: Int = 5
    ) = (1..size).map { chars.random() }.joinToString("")

    fun getTextNumbers(
        size: Int = 5
    ) = (1..size).map { charDigits.random() }.joinToString("")

    fun getNumbers(
        count: Int = 10,
        roof: Int = 999,
    ) = (1..count).map { Random.nextInt(roof) }.toTypedArray()
}