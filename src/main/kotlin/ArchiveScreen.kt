class ArchiveScreen(val currentArchive : Archive) {
    private var currentNotesList = mutableListOf<Note>()
    private var newArchive: Archive? = null

    fun open(): Archive? {
        while (newArchive == null) {
            currentNotesList.clear()
            currentArchive.notesList.forEach { note -> currentNotesList.add(note) }
            showMenu(currentNotesList)
        }
        return newArchive
    }

    private fun addNote() {
        val name = getAnswer("Введите название заметки")
        val text = getAnswer("Введите текст заметки")
        currentNotesList.add(Note(name, text))
        showMenu(currentNotesList)
    }

    private fun openNote(note: Note) {
        note.printNote()
        getAnswer("Чтобы вернуться к списку заметок введите любой символ")
        showMenu(currentNotesList)
    }

    private fun saveArchive() {
        val newNotesList: MutableList<Note> = mutableListOf()
        newNotesList.addAll(currentNotesList)
        newArchive = Archive(currentArchive.name, newNotesList)
    }

    private fun showMenu(commands: List<Note>) {
        println("Список заметок:")
        val currentCommands: List<Pair<String, () -> Unit>> = getCommands(commands)
        chooseCommand(currentCommands)
    }

    private fun getCommands(commands: List<Note>): List<Pair<String, () -> Unit>> {
        var commandsList: MutableList<Pair<String, () -> Unit>> =
            mutableListOf(Pair("0 - Создать заметку", { -> addNote() }))
        commands.forEachIndexed { index, element ->
            commandsList.add(
                Pair(
                    "${index + 1} - ${element.name}",
                    { -> openNote(element) })
            )
        }
        commandsList.add(Pair("${commandsList.size} - Выход", { -> saveArchive() }))
        return commandsList
    }
}