package screens

import model.Note
import java.util.*

object ViewNoteScreen {
    fun start(note: Note) {
        println("Имя заметки: ${note.name}\nТекст заметки: ${note.text}\n" +
                "Введите любой символ для возврата в меню")
        Scanner(System.`in`).nextLine()
    }
}