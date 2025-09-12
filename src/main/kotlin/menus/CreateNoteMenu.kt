package menus

import models.Archive
import models.Note
import java.util.*

fun createNoteMenu(archive: Archive, scanner: Scanner) {
    println("\nВведите название новой заметки (можно оставить пустым):")
    val name = scanner.nextLine().trim()

    println("Введите текст заметки (можно оставить пустым):")
    val text = scanner.nextLine().trim()

    archive.notes.add(Note(name, text))
    println("Заметка добавлена!")
}
