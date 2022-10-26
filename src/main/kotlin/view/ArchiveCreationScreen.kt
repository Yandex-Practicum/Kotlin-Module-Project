package view

import presenter.Presenter

const val SCREEN_TITLE = "Screen #2______создание нового архива"
private const val ENTER_NAME = "введите название нового архива"

class ArchiveCreationScreen(presenter: Presenter, function: () -> (Unit)) : Screen(presenter, function) {
    override fun show() {
        println(SCREEN_TITLE)
        println(ENTER_NAME)
        presenter.addNewArchive(scanner.nextLine())
        println("___________________")
        onBackPressed.invoke()
    }
}
