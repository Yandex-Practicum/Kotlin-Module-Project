class NoteMenu(private val navigator: MenuNavigator, private val archive: Archive) {
    fun show() {
        var shouldExit = false
        while (!shouldExit) {
            val items = mutableListOf<Pair<String, () -> Unit>>()
            items.add(Pair("Создать заметку", { createNote() }))
            archive.notes.forEachIndexed { _, note ->
                items.add(Pair("Открыть заметку: ${note.title}", { showNote(note) }))
            }
            items.add(Pair("Архивы", { shouldExit = true }))

            navigator.showMenu("Заметки:", items)
        }
    }

    private fun createNote() {
        val title = navigator.readString("Введите заголовок заметки: ")
        if (title.isBlank()) {
            println("Заголовок заметки не может быть пустым.")
            return
        }

        val content = navigator.readString("Введите текст заметки: ")
        if (content.isBlank()) {
            println("Текст заметки не может быть пустым.")
            return
        }

        archive.notes.add(Note(title, content))
    }

    private fun showNote(note: Note) {
        NoteViewer(navigator, note).show()
    }
}