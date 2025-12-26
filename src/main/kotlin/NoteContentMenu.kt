import java.util.Scanner

class NoteContentMenu(private val note: Note) : Menu("Заметка: ${note.title}") {
    override fun show() {
        println("\nТекст заметки:\n${note.content}")
        // Просто ждем ввода, чтобы пользователь успел прочитать
        println("\n0. Назад")
        while (true) {
            if (Scanner(System.`in`).nextLine() == "0") break
            else println("Введите 0 для возврата.")
        }
    }
}