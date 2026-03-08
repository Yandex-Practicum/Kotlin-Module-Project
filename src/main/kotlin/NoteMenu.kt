class NoteMenu(val archive: Archive) : BaseMenu("Архив ${archive.name}") {
    init {
        menuItems.add("Создать заметку" to { createNote() })
        refreshNotes()
    }

    fun refreshNotes() {
        val createAction = menuItems[0]
        menuItems.clear()
        menuItems.add(createAction)

        archive.notes.forEach { note ->
            menuItems.add("Заметка ${note.title}" to { showNoteContent(note) })
        }
    }

    fun createNote() {
        val title = inputNonEmpty("Введите название заметки")
        val content = inputNonEmpty("Введите текст заметки")
        archive.notes.add(Note(title, content))
        refreshNotes()
    }

    fun showNoteContent(note: Note) {
        println("Текст заметки ${note.title} ")
        println(note.content)
        println("Нажмите Enter, чтобы вернуться...")
        scanner.nextLine()
    }
}
class ArchiveMenu : BaseMenu("Главное меню") {
    val archives = mutableListOf<Archive>()

    init {
        menuItems.add("Создать архив" to { createArchive() })
    }

    fun createArchive() {
        val name = inputNonEmpty("Введите название нового архива")
        val newArchive = Archive(name)
        archives.add(newArchive)

        menuItems.add("Архив: $name" to { NoteMenu(newArchive).show() })
        println("Архив '$name' создан.")
    }
}