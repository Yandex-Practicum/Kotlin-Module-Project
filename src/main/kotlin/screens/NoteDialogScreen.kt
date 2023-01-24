package screens

import data.Note
import java.util.*

class NoteDialogScreen(private val note: Note, private val parentScreen: ListNotesScreen) {
    fun show() {
        println()
        while (true) {
            println(
                "Меню:\n" +
                        "0 - Открыть заметку ${note.title}\n" +
                        "1 - Выход"
            )

            try {
                when (Scanner(System.`in`).nextInt()) {
                    0 -> select()
                    1 -> parentScreen.show()
                    else -> println("Введено неверное значение. Введите 0 или 1")
                }
            } catch (ex: InputMismatchException) {
                println()
                println("Ошибка! Необходимо ввести цифру!")
                println()
            }
        }
    }

    private fun select() = NoteScreen(note, this).show()
}