fun viewNotesMenu() {
    selectAction(
        "Список заметок для $currentArchive",
        listOf("Создать заметку", "Выбрать заметку"),
        ::onNotesMenuAction
    )
}

fun onNotesMenuAction(action: Int) {
    when (action) {
        0 -> addNote()
        1 -> notes[currentArchive]?.let { viewNotes(it) }
    }
}

fun addNote() {
    notes[currentArchive]?.add(getNewItem("Введите текст заметки:"))
    println("Заметка записана.\n")
}

fun viewNotes(notes: MutableList<String>) {
    if (notes.isEmpty()) println("Ещё не введено ни одной заметки.\n")
    else {
        selectAction(
            caption = "Выберите заметку",
            notes.map { it.substring(0, it.length.coerceAtMost(15)) },
            ::onNotesListMenuAction
        )
    }
}

fun onNotesListMenuAction(action: Int) {
    println("Заметка из архива $currentArchive:")
    println("=====")
    println(notes[currentArchive]?.get(action))
    println("=====")
    getNewItem("Для выхода введите любой символ.")
}