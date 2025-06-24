package utils

typealias Stack<E> = ArrayDeque<E>

fun <E> Stack<E>.pop(): E = removeLast()

fun <E> Stack<E>.push(element: E) = addLast(element)

fun String.toIntOrMessage(message: String): Int? = toIntOrNull().also {
    if (it == null) {
        println(message)
    }
}

fun printIndexedList(source: List<Any>, separator: String = " ", indexOffset: Int = 0) {
    source.forEachIndexed { index, element ->
        println("${index + indexOffset}$separator$element")
    }
}