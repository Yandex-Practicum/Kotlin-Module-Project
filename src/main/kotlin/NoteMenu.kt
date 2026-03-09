package menu

import Archive
import Menu
import Note
import NoteScreen
import java.util.Scanner

class NoteMenu(private val archive: Archive) {

    private val scanner = Scanner(System.`in`)

    fun start() {
        val menu = Menu("Архив: ${archive.name}")

        menu.addItem("Создать заметку") { createNote() }
        menu.addItem("Открыть заметку") { openNote() }
        menu.addItem("Назад", exit = true) {}

        menu.show()
    }

    private fun createNote() {
        println("Введите название заметки:")
        val title = scanner.nextLine()

        if (title.isBlank()) {
            println("Название не может быть пустым")
            return
        }

        println("Введите текст заметки:")
        val text = scanner.nextLine()

        if (text.isBlank()) {
            println("Текст не может быть пустым")
            return
        }

        archive.notes.add(Note(title, text))
        println("Заметка создана")
    }

    private fun openNote() {
        if (archive.notes.isEmpty()) {
            println("Заметок нет")
            return
        }

        archive.notes.forEachIndexed { index, note ->
            println("$index. ${note.title}")
        }

        println("Введите номер заметки:")
        val index = scanner.nextLine().toIntOrNull()

        if (index == null || index !in archive.notes.indices) {
            println("Неверный номер")
            return
        }

        NoteScreen(archive.notes[index]).show()
    }
}


























