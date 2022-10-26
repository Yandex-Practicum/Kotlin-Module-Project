package view

import presenter.Presenter
import java.util.*

class ArchiveCreationScreen(presenter: Presenter,  function: () -> (Unit)) : Screen(presenter, function ) {
    override fun show() {
        println("Screen #2______создание нового архива______")
        println("введите название нового архива")
        val name = scanner.nextLine()
        presenter.addNewArchive(name)
        println("архив $name создан")
        println("___________________")
        onBackPressed.invoke()
    }
}
