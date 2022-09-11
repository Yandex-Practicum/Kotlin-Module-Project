private var archiveName = ""
private var currentNotesList = mutableListOf<Note>()
private var archivePosition = 0

fun openArchiveScreen(archive: Archive, position: Int) {
    currentNotesList.clear()
    archiveName = archive.name
    archivePosition = position

    archive.notesList.forEach { note -> currentNotesList.add(note) }
    showArchiveScreenMenu(archive.notesList)
}

fun addNote() {
    val name = getAnswer("Введите название заметки")
    val text = getAnswer("Введите текст заметки")
    currentNotesList.add(Note(name, text))
    showArchiveScreenMenu(currentNotesList)
}

fun openNote(note: Note) {
    note.printNote()
    getAnswer("Чтобы вернуться к списку заметок введите любой символ")
    showArchiveScreenMenu(currentNotesList)
}

fun saveArchive() {
    val newNotesList: MutableList<Note> = mutableListOf()
    newNotesList.addAll(currentNotesList)
    val newArchive = Archive(archiveName, newNotesList)
    updateArchivesList(archivePosition, newArchive)
    openStartScreen()
}

fun showArchiveScreenMenu(commands: List<Note>) {
    println("Список заметок:")
    val currentCommands: List<Pair<String, () -> Unit>> = getArchiveScreenCommands(commands)
    chooseCommand(currentCommands)
}

fun getArchiveScreenCommands(commands: List<Note>): List<Pair<String, () -> Unit>>{
    var commandsList: MutableList<Pair<String, () -> Unit>> = mutableListOf(Pair("0 - Создать заметку", { -> addNote() }))
    commands.forEachIndexed { index, element -> commandsList.add(Pair("${index + 1} - ${element.name}", { -> openNote(element) })) }
    commandsList.add(Pair("${commandsList.size} - Выход", { -> saveArchive() }))
    return commandsList
}