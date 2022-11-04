package notes

import base.Archive
import base.BaseCreator
import base.Note
import base.Text
import java.util.*

object CreateNoteScreen: BaseCreator<Archive>()  {

    override fun greetings() {
        println()
        println("------------------------------------------------")
        println("Чтобы создать заметку введите ее название")
        println("Чтобы вернуться назад нажмите - < 0 >")
        println("------------------------------------------------")
        println()
    }

    override fun info() {
        println("------------------------------------------------")
        println("Введите текст заметки")
        println("Чтобы вернуться назад нажмите - < 0 >")
        println("------------------------------------------------")
    }

    override fun someWork(textName: String, archive: Text?) {
        if (archive !is Archive) return
        val noteText = Scanner(System.`in`).nextLine().toString()
        if (noteText == "0") return

        archive.listOfNotes.add(
            Note(
                name = textName,
                text = noteText
            )
        )
        println("Заметка с названием $textName и текстом $noteText создана!")
    }
}