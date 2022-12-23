class NoteScreen(private val note: Note, private val parent: OpenNoteScreen) {
    fun show() {
        while (true) {
            println("Заметка: ${note.ntName}\nТекст:\n${note.data}\nВведите 0, чтобы выйти из режима просмотра.")
            when (readLine()!!.toIntOrNull()) {
                0 -> parent.show()
                null -> println("Ошибка ввода: ожидалось число")
                else -> println("Ошибка ввода: введено недопустимое число")
            }
        }
    }
}