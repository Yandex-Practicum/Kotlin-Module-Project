package menu

import modules.Note

fun displayNote(note: Note) {
    println("Заголовок заметки: ${note.title}")
    println("Содержимое заметки: ${note.content}")
    println()
}