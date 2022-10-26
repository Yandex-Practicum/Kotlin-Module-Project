package view

import model.Note
import presenter.Presenter

class NoteScreen(private val note: Note, presenter: Presenter) :Screen(presenter) {

    override fun show() {
        println("__________${note.title}__________")
        println(note.text)
        println("____________________")
    }

}