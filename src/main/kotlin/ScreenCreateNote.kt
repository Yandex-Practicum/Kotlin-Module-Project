import dataClass.Note
import java.util.Scanner

class ScreenCreateNote {

    fun create(notes: MutableList<Any>): Note {

        var enterStringTitleNote = ""
        var enterStringBodyNote = ""
        while(enterStringTitleNote.isEmpty()) {
            println("Введите заголовок заметки")
            enterStringTitleNote = Scanner(System.`in`).nextLine()
        }
        while(enterStringBodyNote.isEmpty()) {
            println("Введите текст заметки")
            enterStringBodyNote = Scanner(System.`in`).nextLine()
        }
        val note = Note(enterStringTitleNote, enterStringBodyNote)
        return note
    }
}