class NoteListMenu(private val archive: Archive) : Menu("Архив: ${archive.name}") {
    override fun show() {
        runMenu(
            items = archive.notes,
            getItemName = { it.title },
            onSelect = { note -> NoteContentMenu(note).show() },
            onCreate = {
                val title = readNonEmptyString("Введите название заметки:")
                val content = readNonEmptyString("Введите текст заметки:")
                archive.notes.add(Note(title, content))
                println("Заметка '$title' добавлена.")
            },
            exitText = "Назад в меню архивов"
        )
    }
}