package ui
import models.Archive
import models.Note

class NoteMenu(private val notes: MutableList<Note>) : Menu<Note>(
    title = "Меню заметок",
    createItemText = "Создать заметку"
) {
    override fun getItemsList(): List<Note> = notes

    override fun getItemName(item: Note): String = item.title

    override fun onItemSelected(item: Note) {
        showNoteContent(item)
    }

    override fun onCreateItem() {
        while (true) {
            val title = ConsoleReader.readLine("Введите название заметки: ")

            if (title.isBlank()) {
                println("Название заметки не может быть пустым")
                continue
            }

            val content = ConsoleReader.readLine("Введите текст заметки: ")

            if (content.isBlank()) {
                println("Текст заметки не может быть пустым")
                continue
            }

            notes.add(Note(title, content))
            println("Заметка \"$title\" создана")
            break
        }
    }

    private fun showNoteContent(note: Note) {
        println("\n=== ${note.title} ===")
        println(note.content)
        println("\nНажмите Enter для возврата...")
        ConsoleReader.readLine("")
    }
}