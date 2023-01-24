package screens

import data.Note
import java.util.*

class NoteScreen(private val note: Note, private val parent: NoteDialogScreen) {
    fun show() {
        while (true) {
            println(
                "Оглавление: ${note.title}\n" +
                        "Текст заметки:\n" +
                        "${note.text}\n" +
                        "Для выхода нажмите enter"
            )
            Scanner(System.`in`).nextLine()
            parent.show()
        }
    }
}