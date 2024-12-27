class Archive(val name: String) {
    private val notes = mutableListOf<Note>()

    fun showNotesMenu() {
        while (true) {
            println("Архив: $name")
            println("0. Создать заметку")
            for ((index, note) in notes.withIndex()) {
                println("${index + 1}. ${note.title}")
            }
            println("${notes.size + 1}. Назад")
            print("Введите номер пункта: ")

            val input = readLine()
            if (input == null || !input.matches("\\d+".toRegex())) {
                println("Пожалуйста, введите число.")
                continue
            }

            val choice = input.toInt()
            when {
                choice == 0 -> createNote()
                choice in 1..notes.size -> notes[choice - 1].showContent()
                choice == notes.size + 1 -> return
                else -> println("Некорректный ввод. Попробуйте снова.")
            }
        }
    }

    fun createNote() {
        print("Введите название заметки: ")
        val title = readLine().orEmpty()
        if (title.isBlank()) {
            println("Название заметки не может быть пустым.")
            return
        }

        print("Введите текст заметки: ")
        val content = readLine().orEmpty()
        if (content.isBlank()) {
            println("Текст заметки не может быть пустым.")
            return
        }

        notes.add(Note(title, content))
        println("Заметка '$title' создана.")
    }
}
