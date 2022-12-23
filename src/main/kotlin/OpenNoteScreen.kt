class OpenNoteScreen(private val note: Note, private val parent: OpenArchiveScreen) {
    fun show() {
        while (true) {
            println("Выберите действие?\n0.Посмотреть заметку ${note.ntName}\n1.Выход")
            when (readLine()!!.toIntOrNull()) {
                0 -> select()
                1 -> parent.show()
                null -> println("Ошибка ввода: ожидалось число")
                else -> println("Ошибка ввода: введено недопустимое число")
            }
        }
    }

    private fun select() {
        val viewNote = NoteScreen(note, this)
        viewNote.show()
    }
}