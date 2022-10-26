package view

import presenter.Presenter
import java.util.*

class ArchiveCreationScreen(presenter: Presenter,  function: () -> (Unit)) : Screen(presenter, function ) {
    private val scanner = Scanner(System.`in`)

    override fun show() {
        println("Screen #2______ArchiveCreationScreen______")
        println("CREATE ARCHIVE")
        println("enter name")
        val name = scanner.nextLine()
        presenter.addNewArchive(name)
        println("archive $name created")
        println("___________________")
        onBackPressed.invoke()
    }
}
