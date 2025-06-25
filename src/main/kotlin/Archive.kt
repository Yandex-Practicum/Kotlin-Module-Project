class Archive(val archiveName: String) {
    val notes = mutableListOf<Note>()

    fun addNote() {
        println("=== Создание новой заметки ===")
        println("Введите заголовок новой заметки:")
        val noteTitle = promptForNonEmptyInput("Ошибка: заголовок не может быть пустым!")

        println("Введите текст заметки:")
        val noteContent = promptForNonEmptyInput("Ошибка: текст заметки не может быть пустым!")

        notes.add(Note(noteTitle, noteContent))
        println("Заметка '$noteTitle' успешно создана")
    }

    fun showNotes() {
        if (notes.isEmpty()) {
            println("В архиве '$archiveName' пока нет заметок")
            return
        }

        val noteMenu = Menu("=== Заметки в архиве '$archiveName' ===")
        notes.forEachIndexed { index, currentNote ->
            noteMenu.addItem(currentNote.title) {
                println("=== ${currentNote.title} ===")
                println(currentNote.contents)
            }
        }
        noteMenu.addItem("Вернуться к списку архивов") {}
        noteMenu.display()
    }

    private fun promptForNonEmptyInput(errorMessage: String): String {
        while (true) {
            val inputLine = readln().trim()
            if (inputLine.isNotBlank()) return inputLine
            println(errorMessage)
            println("Пожалуйста, повторите ввод:")
        }
    }
}
