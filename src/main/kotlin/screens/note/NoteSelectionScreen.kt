package screens.note

import MenuLogic
import entities.Archive
import entities.MenuItem
import screens.archive.ArchiveSelectionScreen

object NoteSelectionScreen {

    private val menu = mutableListOf<MenuItem>()
    private val menuLogic = MenuLogic(menu)

    fun showNotes(archive: Archive, archives: MutableList<Archive>) {
        print("Список заметок: ")
        createNoteSelectionMenu(archive, archives)
        menuLogic.showMenu()
    }

    private fun createNoteSelectionMenu(archive: Archive, archives: MutableList<Archive>) {
        menu.clear()

        menu.add(
            MenuItem("Перейти к предыдущему экрану ") {
                ArchiveSelectionScreen.showArchives(
                    archives
                )
            }
        )

        for (note in archive.notes) {
            val menuItem = MenuItem(
                note.name
            ) { NoteScreen.showNote(note, archive, archives) }
            menu.add(menuItem)
        }

        menu.add(
            MenuItem("Создать заметку") { NoteCreatingScreen.createNote(archive, archives) }
        )
    }
}