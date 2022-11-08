package screens

import data.DataSource
import java.util.*

object CreateNoteScreen: CreateScreenAbstract() {
    override val startOfCreationLine = "Создание заметки"
    override val endOfCreationLine = "Заметка создана!"

    override fun readElement(parentId: Int) {
        println("Введите имя заметки:")
        val name = Scanner(System.`in`).nextLine()
        println("Введите текст заметки:")
        val text = Scanner(System.`in`).nextLine()
        DataSource.addNote(name, parentId, text)
    }
}