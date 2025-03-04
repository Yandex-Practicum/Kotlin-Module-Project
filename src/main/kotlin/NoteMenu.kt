class NoteMenu(private val archive: Archive, private val navigator: MenuNavigator) {
    fun show() {
        while (true) {
            val options = listOf(
                Pair("Создать заметку", { createNote() }),
                Pair("Назад", { null })
            ) + archive.notes.map { Pair(it.name, { showNote(it) }) }

            val choice = navigator.showMenu(options)
            if (choice == null) {
                break
            }
        }
    }

    private fun createNote(): Note {
        println("Введите имя заметки:")
        val name = readLine() ?: ""
        if (name.isEmpty()) {
            println("Заметка не может быть без имени.")
            return createNote()
        }

        println("Введите содержание заметки:")
        val content = readLine() ?: ""
        if (content.isEmpty()) {
            println("Заметка не может быть пустой.")
            return createNote()
        }

        val note = Note(name, content)
        archive.notes.add(note)
        println("Заметка создана. Возвращаемся к меню заметок.")
        return note
    }

    private fun showNote(note: Note) {
        println("Имя заметки: ${note.name}")
        println("Содержание заметки: ${note.content}")
        println("Нажмите Enter для возврата...")
        readLine()
    }
}