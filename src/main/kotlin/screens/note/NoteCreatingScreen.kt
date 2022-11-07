package screens.note

import entities.Archive
import entities.Note
import screens.archive.ArchiveScreen
import java.util.*

object NoteCreatingScreen {

    fun createNote(archive: Archive, archives: MutableList<Archive>) {
        print("Введите имя заметки: ")
        val name = Scanner(System.`in`).nextLine().toString()

        print("Введите текст заметки: ")
        val text = Scanner(System.`in`).nextLine().toString()
        println()

        val note = Note(
            name = name,
            text = text,
        )

        archive.notes.add(note)
        ArchiveScreen.showArchive(archive, archives)
    }
}