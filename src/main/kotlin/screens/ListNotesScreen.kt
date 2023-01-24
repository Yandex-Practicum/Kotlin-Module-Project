package screens

import data.Note
import java.util.*

class ListNotesScreen(private val list: MutableList<Note>, private val parentScreen: ListArchiveScreen) :
    Screen<Note>("заметка", list) {

    override fun add() {
        println("Создание новой заметки.\nВведите название новой заметки:")

        val scanner = Scanner(System.`in`).nextLine()
        println("Введите текст заметки:")
        val text = Scanner(System.`in`).nextLine()
        list.add(Note(scanner, text))

        println("Заметка успешно создана!\n")
        show()
    }

    override fun select(i: Int) {
        NoteDialogScreen(list[i], this).show()
    }

    override fun exit() {
        parentScreen.show()
    }
}