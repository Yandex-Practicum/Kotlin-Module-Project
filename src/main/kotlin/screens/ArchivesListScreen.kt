package screens

import data.Database
import model.MenuItem

class ArchivesListScreen {

    private var menuWorker: MenuWorker = MenuWorker(listOfWhat = "Список архивов:")

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
        menuItems[0] = MenuItem("0. Создать архив") { CreateArchiveScreen() }
        Database.archives.keys.forEachIndexed { index, archive: String ->
            menuItems[index + 1] =
                MenuItem("${index + 1}. $archive") {
                    NotesListScreen(archive).also { it.start() }
                }
        }
        return menuItems
    }
}