class NoteViewScreen(
    private val note: Note
) {
    fun show() {
        println("Заметка: ${note.title}")
        println(note.text)
        println("Нажмите Enter для возврата...")
        readln()
        // После нажатия Enter возврат в предыдущее меню
    }
}