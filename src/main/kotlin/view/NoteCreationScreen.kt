package view

import model.Archive
import model.Note
import presenter.Presenter
import java.util.*

class NoteCreationScreen(private val archive: Archive, presenter: Presenter, val function: () -> (Unit)) :Screen(presenter,function) {

    override fun show() {
        println("Screen #4_______создание заметки для архива: ${archive.name}_____")
        println("введите название заметки:")
        val title = scanner.nextLine()
        println("введите текст заметки:")
        val text = scanner.nextLine()
        archive.notes.add(Note(title = title, text = text))
        println("_________заметка $title создана__________")
        onBackPressed.invoke()
    }
}