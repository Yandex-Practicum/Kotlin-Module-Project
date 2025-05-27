object Navigation {
    private val archives = mutableListOf<Archive>()

    fun start() {
        showArchivesMenu()
    }

    private fun showArchivesMenu() {
        Menu(
            title = "Список архивов:",
            items = archives,
            itemToString = { it.name },
            onItemSelected = { showNotesMenu(it) },
            onCreate = {
                println("Введите название архива:")
                val name = readNonEmptyString()
                val newArchive = Archive(name)
                archives.add(newArchive)
                showNotesMenu(newArchive)
                false
            },
            onExit = {
                println("Выход из программы. Пока!")
            },
            createItemText = "Создать новый архив" // Специфичный текст для архивов
        ).show()
    }

    private fun showNotesMenu(archive: Archive) {
        Menu(
            title = "Заметки архива '${archive.name}':",
            items = archive.notes,
            itemToString = { it.title },
            onItemSelected = { showNote(it) },
            onCreate = {
                println("Введите заголовок заметки:")
                val title = readNonEmptyString()
                println("Введите текст заметки:")
                val content = readNonEmptyString()
                archive.notes.add(Note(title, content))
                false
            },
            onExit = {
                // Возвращаемся в меню архивов
            },
            createItemText = "Создать новую заметку" // Специфичный текст для заметок
        ).show()
    }

    private fun showNote(note: Note) {
        println("\nЗаметка: ${note.title}")
        println("\nСодержание заметки: ${note.content}")
        println("\nНажмите Enter для возврата...")
        readLine()
    }

    private fun readNonEmptyString(): String {
        while (true) {
            val input = readLine()?.trim()
            if (!input.isNullOrBlank()) return input
            println("Пустое значение недопустимо. Повторите ввод:")
        }
    }
}

