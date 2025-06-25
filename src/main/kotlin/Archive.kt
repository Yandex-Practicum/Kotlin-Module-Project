package app

class Archive(val name: String) {
    val notes = mutableListOf<Note>()

    fun addNote() {
        println("Введите название заметки:")
        val name = readNonEmptyLine("Название не может быть пустым.")

        println("Введите содержание заметки:")
        val content = readNonEmptyLine("Содержание не может быть пустым.")

        notes.add(Note(name, content))
        println("Заметка добавлена.")
    }

    fun showNotes() {
        if (notes.isEmpty()) {
            println("Нет заметок в архиве.")
            return
        }

        val noteMenu = Menu("Заметки в архиве '$name'")
        notes.forEachIndexed { index, note ->
            noteMenu.addItem(note.name) {
                println("\n--- ${note.name} ---")
                println(note.content)
            }
        }
        noteMenu.addItem("Назад") {}
        noteMenu.show()
    }

    private fun readNonEmptyLine(errorMsg: String): String {
        while (true) {
            val line = readln()
            if (line.isNotBlank()) return line
            println(errorMsg)
        }
    }
}