class NoteScreen(private val note: Note) {

    fun show() {
        Menu("\nЗаметка \"${note.title}\":\n${note.text}\n", "Назад") { emptyList() }.show()
    }
}
