package notes

import base.Archive
import base.Note
import java.util.*

object CreateNoteScreen {

    fun createNote(archive: Archive) {
        println()
        println("------------------------------------------------")
        println("Чтобы создать заметку введите ее название")
        println("Чтобы вернуться назад нажмите - < 0 >")
        println("------------------------------------------------")
        println()

        while (true) {
            val noteName = Scanner(System.`in`).nextLine().toString()
            if (noteName == "0") return

            println("------------------------------------------------")
            println("Введите текст заметки")
            println("Чтобы вернуться назад нажмите - < 0 >")
            println("------------------------------------------------")

            val noteText = Scanner(System.`in`).nextLine().toString()
            if (noteText == "0") return

            archive.listOfNotes.add(
                Note(
                    name = noteName,
                    text = noteText
                )
            )
            println("Заметка с названием $noteName и текстом $noteText создана!")
            return
        }
    }
}