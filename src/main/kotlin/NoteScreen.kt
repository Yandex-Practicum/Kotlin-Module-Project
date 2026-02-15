import java.util.Scanner

class NoteScreen(private val archive: Archive) {
    private val input = InputUtils()

    fun show() {
        Menu(
            title = "Архив '${archive.name}': ЗАМЕТКИ",
            items = archive.notes,
            itemToString = { note -> note.title },
            onCreate = { createNote() },
            onSelect = { note -> viewNote(note) },
            exitText = "Назад"
        ).show()
    }

    private fun createNote() {
        val title = input.readString("Введите название заметки:")
        val content = input.readString("Введите текст заметки:")
        archive.notes.add(Note(title, content))
        println("Заметка '$title' создана!")
    }

    private fun viewNote(note: Note) {
        println("\n--- Просмотр заметки ---")
        println("Заголовок: ${note.title}")
        println("Текст: ${note.content}")
        println("\nНажмите Enter, чтобы вернуться назад...")
        Scanner(System.`in`).nextLine()
    }
}