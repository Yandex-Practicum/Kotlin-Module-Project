package view

import presenter.Presenter
import java.util.*

class ArchiveCreationScreen(presenter: Presenter) : Screen(presenter) {
    val scanner = Scanner(System.`in`)

    override fun show() {
        println("______________")
        println("CREATE ARCHIVE")
        println("enter name")
        val name = scanner.nextLine()
        presenter.addNewArchive(name)
        println("archive $name created")
        println("___________________")
    }
}
