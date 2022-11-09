package screens

import MenuLogic
import entities.Archive
import entities.MenuItem
import screens.archive.ArchiveCreatingScreen
import screens.archive.ArchiveSelectionScreen
import screens.interfaces.Screen
import kotlin.system.exitProcess

object BaseScreen: Screen {

    private val archives = mutableListOf<Archive>()

    override val menu = mutableListOf(
        MenuItem("Выйти из программы") { closeApplication() },
        MenuItem("Посмотреть архивы") { ArchiveSelectionScreen.show(archives) },
        MenuItem("Создать архив") { ArchiveCreatingScreen.create(archives) },
    )


    override val menuLogic = MenuLogic(menu)

    fun start() {
        menuLogic.showMenu()
    }

    private fun closeApplication() {
        exitProcess(0)
    }
}