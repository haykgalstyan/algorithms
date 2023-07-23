package data

object Strings {

    fun strings(strings: Int, stringLength: Int) =
        Array(strings) { string(stringLength) }

    fun string(size: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..size)
            .map { allowedChars.random() }
            .joinToString("")
    }
}