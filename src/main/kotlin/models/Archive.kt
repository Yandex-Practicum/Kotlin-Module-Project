package models


class Archive(val name: String) {
    private val notes = mutableListOf<Note>()

    fun addNote(name: String, text: String) {
        notes.add(Note(name, text))
    }

    fun existNote(index: Int): Boolean {
        return index >= 0 && index <= notes.size
    }


    fun getNote(index: Int): Note {
        return notes[index]
    }

    fun getNotes(): MutableList<Note> {
        return notes // .mapIndexed { i, note -> "$i - ${note.name}" }
    }

    override fun toString(): String {
        return "$name  (заметок: ${notes.size})"
    }
}