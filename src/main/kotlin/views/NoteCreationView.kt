package views

import data.Note
import java.util.*

class NoteCreationView(private val noteList: MutableList<Note>): View() {
    override var viewName = "Экран создания заметки"

    private fun createNote(){
        println("Введите имя заметки:")
        val noteName = Scanner(System.`in`).nextLine()
        println("Введите текст заметки")
        val noteText = Scanner(System.`in`).nextLine()
        val note = Note(noteName, noteText)
        println("Заметка ${note.name} успешно добавлена.")
        noteList.add(note)
    }

    override fun showContent() {
        println(viewName)
        println("0. Перейти к созданию заметки")
        println("1. Вернуться на экран списка заметок.")
    }

    override fun readCommand(): Int {
        var number: Int?
        while (true) {
            println("Введите команду по номеру поля.")
            number = Scanner(System.`in`).nextLine().toIntOrNull()
            if (number !in 0..noteList.size + 1) {
                println("Введен некорректный номер, ввидите цифру из списка.")
            } else {
                break
            }
        }
        return number!!
    }

    override fun commandReader() {
        while (!isEnd) {
            showContent()
            when (readCommand()) {
                0 -> createNote()
                1 -> exit()
            }
        }
    }

    override fun exit() {
        println("Возвращаемся к экрану списку заметок.")
        isEnd = true
    }
}