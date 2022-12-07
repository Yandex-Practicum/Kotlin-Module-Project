fun viewArchivesMenu() {
    selectAction(
        "Список архивов",
        listOf("Создать архив", "Выбрать архив"),
        ::onArchivesMenuAction
    )
}

fun onArchivesMenuAction(action: Int) {
    when (action) {
        0 -> addArchive()
        1 -> selectArchive()
    }
}

fun addArchive() {
    val archiveName: String = getNewItem("Введите название архива:")
    val archiveNotes: MutableList<String> = mutableListOf()
    notes[archiveName] = archiveNotes
    println("Архив $archiveName записан.\n")
}

fun selectArchive() {
    selectAction("Выберите архив", notes.keys.toList(), ::onArchivesListMenuAction)
}

fun onArchivesListMenuAction(action: Int) {
    currentArchive = notes.keys.toList()[action]
    viewNotesMenu()
}