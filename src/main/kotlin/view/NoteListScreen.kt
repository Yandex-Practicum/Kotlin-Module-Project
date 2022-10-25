package view

import model.Archive
import presenter.Presenter

class NoteListScreen(val archive: Archive, presenter: Presenter) :Screen(presenter) {

    override fun show() {
        archive.notes.forEach { println(it.title) }
    }
}