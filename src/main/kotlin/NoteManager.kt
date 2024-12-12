object NoteManager {

    fun showMenu(archive: Archive) {
        var exitMenu = false
        while (!exitMenu) {
            MainFuncs.displayMenu(
                "Меню заметок для архива: ${archive.name}",
                generateOptions(archive),
                generateActions(archive),
                { exitMenu = true }
            )
        }
    }



    private fun generateOptions(archive: Archive): Array<String> {
        val options = mutableListOf("Создать заметку")
        options.addAll(archive.notes.map { it.title })
        return options.toTypedArray()
    }

    private fun generateActions(archive: Archive): Array<() -> Unit> {
        val actions = mutableListOf<() -> Unit>({ createNote(archive) })
        actions.addAll(archive.notes.map { note -> { viewNote(note) } })
        return actions.toTypedArray()
    }

    private fun createNote(archive: Archive) {
        println("Введите название заметки (или напишите 'отмена' для возврата):")
        val title = readLine()?.trim()
        if (title.isNullOrEmpty() || title.lowercase() == "отмена") {
            println("Создание заметки отменено.")
            return
        }

        println("Введите содержание заметки:")
        val content = readLine()?.trim()
        if (content.isNullOrEmpty()) {
            println("Содержание заметки не может быть пустым.")
            return
        }

        val newNote = Note(title, content)
        archive.notes.add(newNote)
        println("Заметка '$title' успешно создана.")
        NoteManager.showMenu(archive)

    }

    private fun viewNote(note: Note) {
        println("Заметка: ${note.title}")
        println("Содержание: ${note.content}")
    }
}
