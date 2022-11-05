package screens

import data.DataSource
import java.util.*

object CreateNoteScreen {
    fun start(archiveId: Int) {
        println("Создание заметки\nВведите имя заметки:")
        val name = Scanner(System.`in`).nextLine()
        println("Введите текст заметки:")
        val text = Scanner(System.`in`).nextLine()
        DataSource.addNote(name, archiveId, text)
        println("Заметка с именем $name создана")
    }
}