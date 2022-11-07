package screens.archive

import MenuLogic
import entities.Archive
import entities.MenuItem
import screens.note.NoteCreatingScreen
import screens.note.NoteSelectionScreen

object ArchiveScreen {

    private val menu = mutableListOf<MenuItem>()
    private val menuLogic = MenuLogic(menu)

    fun showArchive(archive: Archive, archives: MutableList<Archive>) {
        println("Архив - ${archive.name}")
        if (archive.notes.size == 0) {
            println("Список заметок в архиве ${archive.name} пустой, добавьте заметку")
        } else {
            NoteSelectionScreen.showNotes(archive, archives)
        }
        createArchiveScreenMenu(archive, archives)
        menuLogic.showMenu()
    }

    private fun createArchiveScreenMenu(archive: Archive, archives: MutableList<Archive>) {
        menu.clear()
        menu.add(MenuItem("Перейти к предыдущему экрану") {
            ArchiveSelectionScreen.showArchives(
                archives
            )
        })
        menu.add(MenuItem("Добавить заметку") { NoteCreatingScreen.createNote(archive, archives) })
    }
}