package view

import presenter.Presenter

class NoteScreen(presenter: Presenter) :Screen(presenter) {
    override fun show() {
        println("noteeeee")
    }
}