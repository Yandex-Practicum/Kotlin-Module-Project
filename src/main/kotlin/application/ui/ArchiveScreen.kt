package main.kotlin.application.ui

import main.kotlin.framework.navigation.Navigation
import main.kotlin.framework.ui.UWidget
import main.kotlin.framework.ui.Ui


class ArchiveScreen(navigation: Navigation) : UWidget(navigation) {
    private val menu = listOf("NEW", "SHOW Archives", "EXIT")
    override var ui: Ui = Ui(
        header = "Todo Archive",
        body = menu
    )

    override fun start() {
        super.start()
        inputChecker(menu) { menuNumber ->
            onMenuNumberReceived(menuNumber)
        }
    }

    private fun onMenuNumberReceived(menuNumber: Int) {
        when (menuNumber) {
            0 -> navigation.navigate(NewArchiveScreen(navigation))
            1 -> navigation.navigate(ArchiveListScreen(navigation))
            2 -> destroy()
        }
    }

    override fun reDraw() {
        ui.draw()
        inputChecker(menu) { menuNumber ->
            onMenuNumberReceived(menuNumber)
        }
    }
}