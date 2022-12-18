package views

import data.Note
import java.util.*

class NoteView(private val note: Note) : View() {

    override var viewName = "Заметка ${note.name}"

    private fun changeNoteName() {
        println("Введите новое имя заметки:")
        note.name = Scanner(System.`in`).nextLine()
    }

    private fun changeNoteText() {
        println("Введите новый текст заметки:")
        note.text = Scanner(System.`in`).nextLine()
    }

    private fun showNoteText(){
        println("Текст заметки: $note.text")
    }


    override fun showContent() {
        println(viewName)
        println("0. Изменить имя заметки")
        println("1. Изменить текст заметки")
        println("2. Посмотреть текст заметки")
        println("3. Вернуться к экрану списка заметок")
    }

    override fun readCommand(): Int {
        var number: Int?
        while (true) {
            println("Введите команду по номеру поля.")
            number = Scanner(System.`in`).nextLine().toIntOrNull()
            if (number !in 0..3) {
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
                0 -> changeNoteName()
                1 -> changeNoteText()
                2 -> showNoteText()
                3 -> exit()
            }
        }
    }

    override fun exit() {
        println("Возвращаемся к экрану списка заметок.")
        isEnd = true
    }
}