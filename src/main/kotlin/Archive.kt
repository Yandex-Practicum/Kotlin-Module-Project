
class Archive(val name: String) {
    private val _notes = mutableListOf<Note>()
    val notes: List<Note>
        get() = _notes.toList()

    fun addNote(note: Note) {
        _notes.add(note)
    }
}

fun handleArchive(archive: Archive, menu: Menu) {
    while (true) {
        val noteItems = mutableListOf("Создать заметку", "Назад")
        archive.notes.forEachIndexed { index, note ->
            noteItems.add(index + 1, note.title)
        }

        val choice = menu.showMenu(noteItems, "Список заметок в архиве '${archive.name}':")

        when (choice) {
            0 -> {
                print("Введите название заметки: ")
                val title = readLine()
                if (title.isNullOrEmpty()) {
                    println("Название заметки не может быть пустым.")
                    continue
                }
                print("Введите текст заметки: ")
                val content = readLine()
                if (content.isNullOrEmpty()) {
                    println("Текст заметки не может быть пустым.")
                    continue
                }
                archive.addNote(Note(title, content))
                println("Заметка '$title' создана.")
            }
            noteItems.size - 1 -> {
                return
            }
            else -> {
                val note = archive.notes[choice - 1]
                println("Заметка: ${note.title}")
                println("Текст: ${note.content}")
                println("Нажмите Enter чтобы вернуться назад.")
                readLine()
            }
        }
    }
}

