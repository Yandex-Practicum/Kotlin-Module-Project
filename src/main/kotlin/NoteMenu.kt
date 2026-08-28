class NoteMenu(private val archive: Archive) {

    fun show() {
        Menu("\nАрхив \"${archive.title}\". Список заметок:", "Назад") {
            val items = mutableListOf(MenuItem("Создать заметку") { createNote() })
            archive.notes.forEach { note ->
                items.add(MenuItem(note.title) { NoteScreen(note).show() })
            }
            items
        }.show()
    }

    private fun createNote() {
        val title = Menu.readNonEmptyLine("Введите название заметки: ")
        val text = Menu.readNonEmptyLine("Введите текст заметки: ")
        archive.notes.add(Note(title, text))
        println("Заметка \"$title\" создана.")
    }
}
