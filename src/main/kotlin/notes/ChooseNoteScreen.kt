package notes

import base.Archive
import java.util.*

object ChooseNoteScreen {

    fun openNote(archive: Archive) {
        while (true) {
            println("Чтобы открыть заметку введите ее название")
            println("Чтобы вернуться назад введите - < 0 >")
            println()

            val noteName = Scanner(System.`in`).nextLine().toString()
            if (noteName == "0") return

            val note = archive.listOfNotes.find { it.name == noteName }

            if (note == null) {
                println("Нет такой заметки")
                continue
            }

            println("Заметка открылась, текст заметки - ${note.text}")
            return
        }
    }
}