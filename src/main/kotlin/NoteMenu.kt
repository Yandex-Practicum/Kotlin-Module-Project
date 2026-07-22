class NoteMenu(
    private val archive: Archive
) {

    fun show() {
        while (true) {
            val items = mutableListOf("Создать заметку")

            archive.notes.forEach { note ->
                items.add(note.name)
            }

            items.add("Назад")

            val menu = Menu(
                title = "Заметки архива «${archive.name}»:",
                items = items
            )

            when (val choice = menu.show()) {
                0 -> createNote()

                items.lastIndex -> return

                else -> {
                    val note = archive.notes[choice - 1]
                    showNote(note)
                }
            }
        }
    }

    private fun createNote() {
        println()
        print("Введите название заметки: ")

        val name = readln().trim()

        if (name.isEmpty()) {
            println("Название заметки не может быть пустым.")
            return
        }

        print("Введите текст заметки: ")

        val content = readln().trim()

        if (content.isEmpty()) {
            println("Текст заметки не может быть пустым.")
            return
        }

        archive.notes.add(
            Note(
                name = name,
                content = content
            )
        )

        println("Заметка «$name» создана.")
    }

    private fun showNote(note: Note) {
        println()
        println("Заметка: ${note.name}")
        println("--------------------")
        println(note.content)
        println("--------------------")
        println("Нажмите Enter, чтобы вернуться назад.")
        readln()
    }
}