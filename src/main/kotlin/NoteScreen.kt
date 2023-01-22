import java.util.Scanner

class NoteScreen(private val note : Notes, private val parent : OpenNote) {
    fun show() {
        while (true) {
            println("Заметка:\n${note.noteName}\nТекст заметки:\n${note.text}\nДля выхода из заметки введите любое значение")
            val exit = Scanner(System.`in`).nextLine()
            parent.show()
        }
    }
}