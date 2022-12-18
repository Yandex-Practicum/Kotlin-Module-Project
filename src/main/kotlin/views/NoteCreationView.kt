package views

import data.Note
import java.util.*

class NoteCreationView(private val noteList: MutableList<Note>) : View() {
    override var viewName = "Экран создания заметки"
    override var navigateText = "Возвращаемся к экрану списку заметок."
    override var commandNumbers = 2

    private fun createNote(): () -> Unit = {
        println("Введите имя заметки:")
        val noteName = Scanner(System.`in`).nextLine()
        println("Введите текст заметки")
        val noteText = Scanner(System.`in`).nextLine()
        val note = Note(noteName, noteText)
        println("Заметка ${note.name} успешно добавлена.")
        noteList.add(note)
    }

    override fun createCommands(): MutableList<Pair<String, () -> Unit>> {
        val commandList = mutableListOf<Pair<String, () -> Unit>>()
        commandList.add(
            Pair("0. Перейти к созданию заметки", createNote()))
        commandList.add(Pair("1. Вернуться на экран списка заметок.", exit()))
        return commandList
    }
}