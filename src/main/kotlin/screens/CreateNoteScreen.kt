package screens

import model.Archive
import model.Note
import java.util.Scanner

class CreateNoteScreen(private val archive: Archive) {
    private val scanner = Scanner(System.`in`)

    fun show() {
        print("Введите заголовок: ")
        val title = scanner.nextLine()

        print("Введите текст заметки: ")
        val text = scanner.nextLine()

        if (title.isBlank() || text.isBlank()) {
            println("Заголовок и текст не могут быть пустыми")
            return
        }

        archive.notes.add(Note(title, text))
        println("Заметка создана")
    }
}
