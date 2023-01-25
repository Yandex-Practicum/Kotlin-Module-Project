import java.util.Scanner
class OpenNote(private val note : Notes, private val parent : OpenArchive) {
    fun show() {
        while (true) {
            println("Выберите действие:\n0 - Показать заметку ${note.noteName}\n1 - Выход")
            when (Scanner(System.`in`).nextLine().toIntOrNull()) {
                0 -> select()
                1 -> parent.show()
                else -> println("Введенное значение недопустимо. Введите значение 0 или 1")
            }
        }
    }

    private fun select() {
        val showNote = NoteScreen(note,this)
        showNote.show()
    }
}