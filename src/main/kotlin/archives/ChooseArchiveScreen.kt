package archives

import base.Archive
import base.BaseOpener
import base.Text
import notes.ChooseNoteScreen
import notes.CreateNoteScreen
import java.util.*

object ChooseArchiveScreen : BaseOpener<Archive>() {

    override fun info() = Unit
    override fun greetings() {
        println("Введите название архива или цифру < 0 > для возвращения в главное меню")
    }

    override fun someWork(archive: Archive, stopLoop: () -> Unit) {
        showText(archive.listOfNotes, NOTE_TEXT)

        while (true) {
            showOptions()
            when (Scanner(System.`in`).nextLine().toString()) {
                "1" -> CreateNoteScreen.createText(archive)
                "2" -> ChooseNoteScreen.openText(archive.listOfNotes)
                "3" -> showText(archive.listOfNotes, NOTE_TEXT)
                "0" -> {
                    stopLoop.invoke()
                    return
                }

                else -> println("Неправильная команда!!!")
            }
        }
    }

    fun showText(text: List<Text>, typeName: String) {
        if (text.isEmpty()) {
            println("Пока здесь ничего нет!")
        } else {
            text.forEach {
                println("$typeName - ${it.name}")
            }
        }
        println()
    }

    private fun showOptions() {
        println()
        println("------------------------------------------------")
        println("Чтобы создать заметку нажмите - 1")
        println("Чтобы открыть заметку нажмите - 2")
        println("Чтобы показать список заметок нажмите - 3")
        println("Чтобы вернуться назад нажмите - 0")
        println("------------------------------------------------")
        println()
    }
}