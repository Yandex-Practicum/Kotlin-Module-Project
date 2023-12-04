import java.util.*
//меню заметки

class NoteScreen(val note: Note, val scanner: Scanner) {
    fun show() {
        println("\nЗаметка: ${note.title}")
        println("${note.content}")
        println("\nНажмите Enter, чтобы выйти.")
        scanner.nextLine()
    }
}