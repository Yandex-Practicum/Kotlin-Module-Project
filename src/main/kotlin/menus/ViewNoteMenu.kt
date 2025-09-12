package menus

import models.Note
import java.util.*

fun viewNoteMenu(note: Note, scanner: Scanner) {
    while (true) {
        println("\n--- Просмотр заметки ---")
        println("Название: ${note.name.ifEmpty { "(без названия)" }}")
        println("Текст: ${note.text.ifEmpty { "(пусто)" }}")
        println("0. Назад")

        val input = scanner.nextLine()
        if (input == "0") return
    }
}
