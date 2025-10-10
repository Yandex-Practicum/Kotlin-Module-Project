class NoteMenu(private val archive: Archive) {

    fun show(): Boolean {
        val menu = SelectionMenu(
            title = "АРХИВ: ${archive.name}",
            items = archive.notes,
            itemDisplay = { it.title }
        )

        val shouldContinue = menu.show(
            onItemSelected = { note ->
                showNote(note)
                true
            },
            onCreate = {
                createNote()
                true
            }
        )

        if (!shouldContinue) {
            println("Возврат к списку архивов...")
        }
        return true
    }

    private fun createNote() {
        val title = SelectionMenu.readInput("Введите название заметки: ")
        val content = SelectionMenu.readInput("Введите текст заметки: ")

        archive.addNote(Note(title, content))
        println("Заметка '$title' успешно создана!")
    }

    private fun showNote(note: Note) {
        println("\nЗАМЕТКА: ${note.title}")
        println("-".repeat(20 + note.title.length))
        println(note.content)
        print("\nНажмите Enter для возврата...")
        SelectionMenu.scanner.nextLine()
        println("Возврат к списку заметок...")
    }
}
