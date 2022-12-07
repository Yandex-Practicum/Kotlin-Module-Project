fun main() {
    val notes: MutableMap<String, MutableList<String>> = mutableMapOf()
    while (true) {
        val archiveListAction = selectAction(
            caption = "Список архивов",
            listOf("Создать архив", "Выбрать архив")
        )
        when (archiveListAction) {
            0 -> {
                val archiveName: String = getNewItem("Введите название архива:")
                val archiveNotes: MutableList<String> = mutableListOf()
                notes[archiveName] = archiveNotes
            }
            1 -> {
                if (notes.isEmpty()) println("Ещё не создано ни одного архива.")
                else {
                    val archivesList: List<String> = notes.keys.toList()
                    val archiveAction = selectAction(caption = "Выберите архив", archivesList)
                    if (archiveAction < archivesList.size) {
                        val archive: String = archivesList[archiveAction]
                        while (true) {
                            val notesListAction = selectAction(
                                caption = "Список заметок для $archive",
                                listOf("Создать заметку", "Выбрать заметку"
                                )
                            )
                            when (notesListAction) {
                                0 -> notes[archive]?.add(getNewItem("Введите текст заметки:"))
                                1 -> notes[archive]?.let { viewNotes(archive, it) }
                                else -> break
                            }
                        }
                    }
                }
            }
            else -> break
        }
    }
}