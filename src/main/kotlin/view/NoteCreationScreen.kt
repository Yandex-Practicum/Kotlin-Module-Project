package view

import model.Archive

import presenter.Presenter

private const val ENTER_TITLE = "введите название заметки:"
private const val ENTER_TEXT = "введите текст заметки:"

class NoteCreationScreen(private val archive: Archive, presenter: Presenter, function: () -> (Unit)) :
    Screen(presenter, function) {

    override fun show() {
        println("Screen #4_______создание заметки для архива: ${archive.name}")
        println(ENTER_TITLE)
        val title = scanner.nextLine()
        println(ENTER_TEXT)
        val text = scanner.nextLine()
        presenter.addNote(archive, title, text)
        onBackPressed.invoke()
    }
}