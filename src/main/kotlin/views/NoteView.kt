package views

import data.Note
import java.util.*

class NoteView(private val note: Note) : View() {
    override var viewName = "Заметка ${note.name}"
    override var navigateText = "Возвращаемся к экрану списка заметок."
    override var commandNumbers = 3

    private fun changeNoteName(): () -> Unit = {
        println("Введите новое имя заметки:")
        note.name = Scanner(System.`in`).nextLine()
        viewName = "Заметка ${note.name}"
    }

    private fun changeNoteText(): () -> Unit = {
        println("Введите новый текст заметки:")
        note.text = Scanner(System.`in`).nextLine()
    }

    private fun showNoteText(): () -> Unit = {
        println("Текст заметки: ${note.text}")
    }

    override fun createCommands(): MutableList<Pair<String, () -> Unit>> {
        val commandList = mutableListOf<Pair<String, () -> Unit>>()
        commandList.add(Pair("0. Изменить имя заметки", changeNoteName()))
        commandList.add(Pair("1. Изменить текст заметки", changeNoteText()))
        commandList.add(Pair("2. Посмотреть текст заметки", showNoteText()))
        commandList.add(Pair("3. Вернуться к экрану списка заметок", exit()))
        return commandList
    }
}