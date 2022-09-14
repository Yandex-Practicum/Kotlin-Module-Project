package main.kotlin.application.ui

import main.kotlin.application.datasource.ArchiveDataSource
import main.kotlin.application.model.Archive
import main.kotlin.framework.navigation.Navigation
import main.kotlin.framework.ui.UWidget
import main.kotlin.framework.ui.Ui


class ArchiveListScreen(navigation: Navigation) : UWidget(navigation) {
    private val dataSource = ArchiveDataSource
    private val menu: List<Archive>
        get() = dataSource.getAll()

    override var ui: Ui = Ui(
        header = "ArchiveList",
        body = menu.map { it.name } + "EXIT"
    )

    override fun start() {
        super.start()
        inputChecker(menu.map { it.name } + "EXIT") {
            onSelectedMenuReceived(it)
        }
    }

    private fun onSelectedMenuReceived(num: Int) {
        when (num) {
            in menu.indices -> navigation.navigate(NoteListScreen(navigation, menu[num].id))
            menu.size -> destroy()
        }
    }

    override fun reDraw() {
        val currentMenu = menu.map { it.name } + "EXIT"
        val newUi = ui.copy(body = currentMenu)
        ui = newUi
        ui.draw()
        inputChecker(currentMenu) {
            onSelectedMenuReceived(it)
        }
    }
}