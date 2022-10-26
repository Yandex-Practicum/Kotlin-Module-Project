package view

import model.Note
import presenter.Presenter
import java.util.*

class NoteScreen(private val note: Note, presenter: Presenter, function: () -> (Unit)) :Screen(presenter, function) {
    override fun show() {
        println("Screen #5_________заметка: ${note.title}_________")
        println(note.text)
        println("____________________")
        println()
        println("0 - НАЗАД")

        while (true) {
            when (scanner.nextLine()) {
                "0" -> onBackPressed.invoke()
                else -> {
                    println("не корректный ввод")
                }
            }
        }

    }
}