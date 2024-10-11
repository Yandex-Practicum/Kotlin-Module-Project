class ArchiveMenu (private val archive: Archive, private val ioHandler: IOHandler){ //меню архивов

    fun show() {
        while (true) {
            val noteNames = archive.notes.map { it.name }

            ioHandler.showList(
                title = "Архив: ${archive.name}",
                items = noteNames,
                footer = "${archive.notes.size + 1}. Назад",
                createOp = "0. Создать заметку"
            )

            when (val choice = ioHandler.getUserChoice()) {
                0 -> createNote(archive)
                in 1..archive.notes.size -> NoteMenu(archive.notes[choice!! - 1],ioHandler).show()
                archive.notes.size + 1 -> break
                else -> ioHandler.showMessage("Неверный выбор, попробуйте снова.\n")
            }
        }
    }
    private fun createNote(archive: Archive) {
        ioHandler.showMessage("Введите название заметки:")
        val name = readlnOrNull().orEmpty()
        ioHandler.showMessage("Введите текст заметки:")
        val body = readlnOrNull().orEmpty()
        if (name.isNotEmpty() && body.isNotEmpty()) {
            archive.notes.add(Note(name, body))
            ioHandler.showMessage("Заметка '$name' создана.\n")
        } else{
            ioHandler.showMessage("Название и текст заметки не может быть пустым!\n")
        }
    }
}