package screens

import objects.Notes
import java.util.Scanner

class NoteTextScreen (val note: Notes) {

    fun showNoteText() {
        println("Заметка: ${note.name}")
        println("Текст: ${note.content}")
        println("Нажмите Enter, чтобы вернуться назад.")
        Scanner(System.`in`).nextLine()
    }
}