class Archive(val name: String) {
    val notes = mutableListOf<Note>()

    override fun toString() = name

    fun createNote() {
        val title = InputHandler.readValidInput("Введите заголовок заметки:") { it.isNotEmpty() }
        val content = InputHandler.readValidInput("Введите текст заметки:") { it.isNotEmpty() }
        notes.add(Note(title, content))
    }
}

class Note(val title: String, val content: String) {
    override fun toString() = title
}