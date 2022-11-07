package screens.note

import MenuLogic
import entities.Archive
import entities.MenuItem
import entities.Note
import screens.archive.ArchiveScreen

object NoteScreen {

    private val menu = mutableListOf<MenuItem>()
    private val menuLogic = MenuLogic(menu)

    fun showNote(note: Note, noteArchive: Archive, archives: MutableList<Archive>) {
        println("Имя заметки - ${note.name}")
        println("Текст заметки - ${note.text}")

        createNoteScreenMenu(noteArchive, archives)
        menuLogic.showMenu()
    }

    private fun createNoteScreenMenu(noteArchive: Archive, archives: MutableList<Archive>) {
        menu.clear()
        menu.add(MenuItem("Перейти к предыдущему экрану") { ArchiveScreen.showArchive(noteArchive, archives) }) }
}