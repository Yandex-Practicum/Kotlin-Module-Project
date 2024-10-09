package menu

import modules.Archive
import utils.readIntInput

fun chooseNote(archive: Archive) {
    if (archive.notes.isEmpty()) {
        println("Заметок нет")
        return
    }

    println("Список заметок")
    archive.notes.forEachIndexed { index, note -> println("${index + 1}. ${note.title}") }
    println("0. Выход")

    val action = readIntInput("Введите номер заметки", 0, archive.notes.size)
    if (action != 0) {
        val selectedNote = archive.notes[action - 1]
        displayNote(selectedNote)
    }
}