package notes

import base.BaseOpener
import base.Note

object ChooseNoteScreen : BaseOpener<Note>() {

    override fun info() {
        println("Чтобы открыть заметку введите ее название")
        println("Чтобы вернуться назад введите - < 0 >")
        println()
    }

    override fun greetings() = Unit

    override fun someWork(text: Note, stopLoop: () -> Unit) {
        println("Заметка открылась, текст заметки - ${text.name}")
        stopLoop.invoke()
        return
    }
}