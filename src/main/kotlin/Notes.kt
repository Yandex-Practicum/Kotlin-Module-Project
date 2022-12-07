fun viewNotes(archive: String, notes: MutableList<String>) {
    if (notes.isEmpty()) println("Ещё не введено ни одной заметки.")
    else {
        while (true) {
            val action: Int = selectAction(
                caption = "Выберите заметку",
                notes.map { it.substring(0, it.length.coerceAtMost(15)) }
            )
            if (action < notes.size) {
                println("Заметка из архива $archive:")
                println("=====")
                println(notes[action])
                println("=====")
                getNewItem("Для выхода введите любой символ.")
            }
            else break
        }
    }
}