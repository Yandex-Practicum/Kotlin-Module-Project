class NotesManager(
    private val archiveManager: ArchiveManager, private val archive: Archive) {
    fun showNotesMenu() {
        val menuScreen = MenuScreen()
        val options = mutableListOf<Pair<String, () -> Unit>>(
            "Создать заметку" to ::createNote,
            "Назад" to ::goBack
        )

        archive.notes.forEachIndexed { index, note ->
            options.add("${index + 2}. ${note.title}" to { showNoteContent(note) })
        }

        menuScreen.showMenu("Список заметок в архиве \"${archive.name}\":", options)
    }

    private fun createNote() {
        println("Введите название заметки:")
        val title = readLine().orEmpty().trim()
        if (title.isNotEmpty()) {
            println("Введите содержание заметки:")
            val content = readLine().orEmpty().trim()
            if (content.isNotEmpty()) {
                val note = Note(title, content)
                archive.notes.add(note)
                println("Заметка \"$title\" создана.")
            } else {
                println("Содержание заметки не может быть пустым.")
            }
        } else {
            println("Название заметки не может быть пустым.")
        }
        showNotesMenu()
    }

    private fun showNoteContent(note: Note) {
        println("Заметка: ${note.title}")
        println(note.content)
        println("Для продолжения нажмите Enter.")
        readLine()
        showNotesMenu()
    }

    private fun goBack() {
        archiveManager.showArchiveMenu()
    }
}