package screens

import model.Note

class NoteScreen(private val note: Note) {

    init {
        showNote()
        print("Для выхода введите любой символ: ")
        readLine()
    }

    private fun showNote() {
        println("${note.title} | ${note.creationDate}")
        println(note.text)
    }
}