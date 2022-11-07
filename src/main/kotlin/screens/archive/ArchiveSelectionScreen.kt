package screens.archive

import MenuLogic
import entities.Archive
import entities.MenuItem
import screens.BaseScreen

object ArchiveSelectionScreen {


    private val menu = mutableListOf<MenuItem>()
    private val menuLogic = MenuLogic(menu)

    fun showArchives(archives: MutableList<Archive>) {
        if (archives.size == 0) {
            println("Список архивов пустой, добавьте архив")
            BaseScreen.start()
        }
        createArchiveSelectionMenu(archives)

        print("Список архивов: ")
        menuLogic.showMenu()
    }

    private fun createArchiveSelectionMenu(archives: MutableList<Archive>) {
        menu.clear()

        menu.add(
            MenuItem("Перейти к предыдущему экрану") { BaseScreen.start() }
        )

        for (archive in archives) {
            val menuItem = MenuItem(
                archive.name
            ) { ArchiveScreen.showArchive(archive, archives) }
            menu.add(menuItem)
        }
    }
}