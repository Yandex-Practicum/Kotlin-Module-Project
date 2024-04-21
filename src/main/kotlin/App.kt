class App {
    private val archives = mutableListOf<Archive>()

    fun start() {
        val mainMenu = Menu(
            listOf(
                "Выбор архива" to { selectArchiveMenu() },
                "Создание архива" to { createArchive() }
            )
        )
        mainMenu.start()
    }

    private fun selectArchiveMenu() {
        if (archives.isEmpty()) {
            println(MenuMessage.EMPTY_ARCHIVES_MESSAGE.message)
            return
        }
        println(MenuMessage.ARCHIVE_LIST_HEADER.message)
        archives.forEachIndexed { index, archive ->
            println("$index. ${archive.name}")
        }
        println(MenuMessage.ARCHIVE_BACK_OPTION.message)
        val input = readlnOrNull()
        if (input == "q") {
            return
        }
        try {
            val archiveIndex = input?.toInt() ?: -1
            if (archiveIndex in archives.indices) {
                val archive = archives[archiveIndex]
                archiveMenu(archive)
            } else {
                println(MenuMessage.INVALID_ARCHIVE_MESSAGE.message)
            }
        } catch (e: NumberFormatException) {
            println(MenuMessage.INVALID_INPUT_MESSAGE.message)
        }
    }

    private fun archiveMenu(archive: Archive) {
        val menu = Menu(
            listOf(
                "Выбор заметки" to { selectNoteMenu(archive) },
                "Создание заметки" to { createNote(archive) },
                "Назад" to { selectArchiveMenu() }
            ),
            parentMenu = null
        )
        menu.start()
    }

    private fun selectNoteMenu(archive: Archive) {
        if (archive.notes.isEmpty()) {
            println(MenuMessage.EMPTY_NOTES_MESSAGE.message)
            return
        }
        println(MenuMessage.NOTE_LIST_HEADER.message)
        archive.notes.forEachIndexed { index, note ->
            println("$index. ${note.title}")
        }
        println(MenuMessage.NOTE_BACK_OPTION.message)
        val input = readlnOrNull()
        if (input == "q") {
            return
        }
        val noteIndex = input?.toIntOrNull()
        if (noteIndex != null && noteIndex in archive.notes.indices) {
            val note = archive.notes[noteIndex]
            displayNoteContent(note)
        } else {
            println(MenuMessage.INVALID_NOTE_MESSAGE.message)
            println(MenuMessage.INVALID_INPUT_MESSAGE.message)
        }
    }

    private fun displayNoteContent(note: Note) {
        println("Заголовок: ${note.title}")
        println("Содержание: ${note.content}")
    }

    private fun createArchive() {
        println(MenuMessage.CREATE_ARCHIVE_PROMPT.message)
        val name = readlnOrNull() ?: ""
        if (name.isBlank()) {
            println(MenuMessage.EMPTY_ARCHIVE_NAME_MESSAGE.message)
            return
        }
        val archive = Archive(name)
        archives.add(archive)
        println(MenuMessage.ARCHIVE_CREATED_MESSAGE.message.format(name))
    }

    private fun createNote(archive: Archive) {
        println(MenuMessage.CREATE_NOTE_TITLE_PROMPT.message)
        val title = readlnOrNull() ?: ""
        println(MenuMessage.CREATE_NOTE_CONTENT_PROMPT.message)
        val content = readlnOrNull() ?: ""
        if (title.isBlank()) {
            println(MenuMessage.EMPTY_NOTE_TITLE_MESSAGE.message)
            return
        }
        if (content.isBlank()) {
            println(MenuMessage.EMPTY_NOTE_CONTENT_MESSAGE.message)
            return
        }
        val note = Note(title, content)
        archive.notes.add(note)
        println(MenuMessage.NOTE_ADDED_MESSAGE.message.format(title))
    }
}
