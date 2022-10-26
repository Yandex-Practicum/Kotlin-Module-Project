package view

import model.Note
import presenter.Presenter
import java.util.*

class NoteScreen(private val note: Note, presenter: Presenter, function: () -> (Unit)) :Screen(presenter, function) {
    private val scanner = Scanner(System.`in`)
    override fun show() {
        println("5_________${note.title}_________5")
        println("0 - НАЗАД")
        println()
        println(note.text)
        println("____________________")
        while (true) {
            val command = scanner.nextLine()
            when (command) {
                "0" -> onBackPressed.invoke()
                else -> {
                    println("nope")
                }
            }
        }

    }
}