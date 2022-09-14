package main.kotlin.application.ui

import main.kotlin.application.datasource.ArchiveDataSource
import main.kotlin.application.model.Archive
import main.kotlin.framework.navigation.Navigation
import main.kotlin.framework.ui.UWidget
import main.kotlin.framework.ui.Ui


class NewArchiveScreen(navigation: Navigation) : UWidget(navigation) {
    private val dataSource = ArchiveDataSource
    override var ui: Ui = Ui(
        header = "CreateNew Archive"
    )

    override fun start() {
        super.start()
        inputChecker(emptyList()) {
            println("SAVE is DONE -----")
            destroy()
        }
    }

    override fun reDraw() {
        //*do noting*//
    }

    override fun inputChecker(menu: List<String>, onMenu: (menuNum: Int) -> Unit) {
        println("Enter the name of list")
        var input = readLine()
        var isProgress = true
        while (isProgress) {
            val final = input?.trim()
            if (final != null) {
                if (final.length > 2) {
                    isProgress = false
                    dataSource.put(
                        Archive(
                            name = final
                        )
                    )
                    onMenu(0)
                    continue
                }
            }
            println("You need to enter more the 2 chars")
            println("plz try again: ")
            input = readLine()
        }
    }
}