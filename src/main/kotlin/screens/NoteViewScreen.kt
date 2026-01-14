package screens

import model.Note

class NoteViewScreen(private val note: Note) {

    fun show() {
        println()
        println(note.title)
        println(note.text)
        println()
        println("Нажмите Enter для возврата")
        readLine()
    }
}
