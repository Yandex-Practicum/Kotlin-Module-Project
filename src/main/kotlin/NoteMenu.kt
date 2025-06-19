class NoteMenu(
    private val notes: MutableList<Note>,
    private val archiveName: String
) : Menu<Note>() {
    override val items: List<Note> = notes
    override val createItemText: String = "Создать заметку"
    override val menuTitle: String = "Список заметок в архиве '$archiveName'"
    override val exitText: String = "Назад"

    override fun displayItem(item: Note): String = item.title

    override fun onCreateItem() {
        println("\nСоздание заметки")
        val title = readNonEmptyInput("Введите название заметки: ")
        val content = readNonEmptyInput("Введите текст заметки: ")
        notes.add(Note(title, content))
        println("Заметка '$title' создана!")
    }

    override fun onItemSelected(item: Note) {
        println("\nЗаметка: ${item.title}")
        println("Текст: ${item.content}")
        println("\nНажмите Enter чтобы вернуться...")
        readlnOrNull()
    }
}