package views

import data.Note
import java.util.*

class NoteViewList(private val noteList: MutableList<Note>) : View() {
    override var viewName = "Экран списка заметок"

    override fun showContent() {
        println(viewName)
        println("0. Перейти к экрану созданию заметок.")
        noteList.forEachIndexed { index, note -> println("${index + 1}. ${note.name}") }
        println("${noteList.size + 1}. Вернуться к экрану списка архивов.")
    }

    override fun readCommand(): Int {
        var number: Int? = null
        while (number !in 0..noteList.size + 1) {
            number = Scanner(System.`in`).nextLine().toIntOrNull()
        }
        return number!!
    }

    override fun commandReader() {
        while (!isEnd) {
            showContent()
            when (val command = readCommand()) {
                0 -> NoteCreationView(noteList).commandReader()
                noteList.size + 1 -> exit()
                else -> NoteView(noteList[command - 1]).commandReader()
            }
        }
    }

    override fun exit() {
        println("Возвращаемся к списку архивов.")
        isEnd = true
    }
}