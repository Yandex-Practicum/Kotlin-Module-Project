class Archive(val name: String) {
    private val notes = mutableListOf<Note>()

    fun showMenu() {
        while (true) {
            println("Список заметок в архиве '$name':")
            println("0. Создать заметку")
            for ((index, note) in notes.withIndex()) {
                println("${index + 1}. ${note.title}")
            }
            println("${notes.size + 1}. Назад")
            val note = NotesApp()
            val choice = note.readUserInput()
            when (choice) {
                0 -> createNote()
                in 1..notes.size -> notes[choice - 1].show()
                notes.size + 1 -> break
                else -> println("Неверный ввод. Попробуйте снова.")
            }
        }
    }


    private fun createNote() {
        println("Введите заголовок заметки:")
        val title = readLine()?.trim()
        if (title.isNullOrEmpty()) {
            println("Заголовок не может быть пустым.")
            return
        }
        println("Введите текст заметки:")
        val content = readLine()?.trim()
        if (content.isNullOrEmpty()) {
            println("Текст заметки не может быть пустым.")
            return
        }
        notes.add(Note(title, content))
        println("Заметка '$title' создана.")
    }
}
