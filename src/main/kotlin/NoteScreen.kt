
import java.util.Scanner

class NoteScreen(private val note: Note) {
    fun show() {
        println("\nЗаметка: ${note.title}")
        println(note.text)
        println("\nНажмите Enter чтобы вернуться")
        Scanner(System.`in`).nextLine()
    }
}
