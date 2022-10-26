package view

import model.Note
import presenter.Presenter

private const val BACK_INFO = "для возврата в предыдущее меню - введите: 0"

class NoteScreen(private val note: Note, presenter: Presenter, function: () -> (Unit)) : Screen(presenter, function) {
    override fun show() {
        println("Screen #5_________заметка: ${note.title}")
        presenter.showNote(note)
        println(BACK)

        while (true) {
            when (scanner.nextLine()) {
                EXIT_COMMAND -> onBackPressed.invoke()
                else -> {
                    println(BACK_INFO)
                }
            }
        }
    }
}