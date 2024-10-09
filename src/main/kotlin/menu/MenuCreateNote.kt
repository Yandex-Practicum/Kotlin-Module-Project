package menu

import modules.Archive
import modules.Note
import utils.readNonBlankString

fun createNote(archive: Archive) {
    val title = readNonBlankString("Введите заголовок заметки:")
    val content = readNonBlankString("Введите содержимое заметки")
    archive.notes.add(Note(title, content))
    println("Заметка \"$title\" была создана")
    println()
}
