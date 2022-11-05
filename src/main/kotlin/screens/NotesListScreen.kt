package screens

import data.Database
import model.MenuItem

class NotesListScreen(private val archive: String) {

    private val menuWorker: MenuWorker = MenuWorker(listOfWhat = "Список заметок:")

    fun start() {
        while (true) {
            menuWorker.menuItems = prepareMenuItems()
            menuWorker.showMenu()
            val isBackPressed = menuWorker.performActionOnMenuItemClick()
            if (isBackPressed) {
                break
            }
        }
    }

    private fun prepareMenuItems(): Map<Int, MenuItem> {
        val menuItems = mutableMapOf<Int, MenuItem>()
        menuItems[0] = MenuItem("0. Создать заметку") { CreateNoteScreen(archive) }
        Database.archives[archive]?.forEachIndexed { index, note ->
            menuItems[index + 1] =
                MenuItem("${index + 1}. ${note.title}") { NoteScreen(note) }
        }
        return menuItems
    }
}