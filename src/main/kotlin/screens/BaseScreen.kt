package screens

import MenuLogic
import entities.Archive
import entities.MenuItem
import screens.archive.ArchiveCreatingScreen
import screens.archive.ArchiveSelectionScreen
import kotlin.system.exitProcess

object BaseScreen {

    private val archives = mutableListOf<Archive>()

    private val menu = mutableListOf(
        MenuItem("Выйти из программы") { closeApplication() },
        MenuItem("Посмотреть архивы") { ArchiveSelectionScreen.showArchives(archives) },
        MenuItem("Создать архив") { ArchiveCreatingScreen.createArchive(archives) },
    )


    private val menuLogic = MenuLogic(menu)

    fun start() {
        menuLogic.showMenu()
    }

    private fun closeApplication() {
        exitProcess(0)
    }
}