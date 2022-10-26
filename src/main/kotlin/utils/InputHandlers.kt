package utils

import java.util.*

/** Возвращает не пустую строку из консоли. Перед считыванием выводит на экран [requestMessage],
 * а при вводе пустой строки [errMessage].
 * Используется в ArchiveCreator и NoteCreator.
 */
fun getStringInput(requestMessage: RequestMessage, errMessage: ErrMessage): String {
    val scanner = Scanner(System.`in`)
    var input: String

    println(requestMessage)
    do {
        input = scanner.nextLine()
        if (input.isNotEmpty()) return input
        println(errMessage)
    } while (true)
}
