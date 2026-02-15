class ArchiveScreen {
    private val archives = mutableListOf<Archive>()
    private val input = InputUtils()

    fun show() {
        Menu(
            title = "СПИСОК АРХИВОВ",
            items = archives,
            itemToString = { archive -> archive.name },
            onCreate = { createArchive() },
            onSelect = { archive -> showNotes(archive) },
            exitText = "Выход"
        ).show()
    }

    private fun createArchive() {
        val name = input.readString("Введите название архива:")
        archives.add(Archive(name, mutableListOf()))
        println("Архив '$name' создан!")
    }

    private fun showNotes(archive: Archive) {
        NoteScreen(archive).show()
    }
}