class NoteViewer(private val navigator: MenuNavigator, private val note: Note) {
    fun show() {
        println("Заметка: ${note.title}")
        println(note.content)
        println("\nНажмите Enter для возврата...")
        navigator.readString("")
    }
}