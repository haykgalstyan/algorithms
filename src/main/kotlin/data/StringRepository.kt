package data

object StringRepository {

    private val chars = ('A'..'Z') + ('a'..'z')

    fun getStrings(
        strings: Int,
        stringLength: Int
    ) = Array(strings) { getString(stringLength) }

    fun getString(size: Int): String {
        return (1..size)
            .map { chars.random() }
            .joinToString("")
    }
}