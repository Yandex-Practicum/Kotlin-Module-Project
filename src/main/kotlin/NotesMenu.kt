class NotesMenu(archive: Archive) : Menu() {
    val notes = archive.notes
    override var commands = mutableListOf<Command>()
    val openingNote: (Int) -> Unit = { index ->
        val note = notes[index - 1]
        println("Вы находитесть в заметке ${note.name}")
        val viewNote = ContentMenu(note)
        viewNote.createListCommandAndView()
    }

    override fun createListCommandAndView() {
        commands = mutableListOf<Command>().apply {
            add(Command("Создать заметку") { createNote() })
            notes.forEach {
                add(Command(it.name, openingNote))
            }
            add(Command("Выйти") { exit() })
        }
        view(commands)
    }

    private fun createNote() {
        val note = Note.create()
        notes.add(note)
        commands.add(commands.size - 1, Command(note.name, openingNote))
    }
}

