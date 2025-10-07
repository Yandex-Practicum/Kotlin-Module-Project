class NoteMenu(private val notes: MutableList<Note>) : Menu<Note>(notes, "Список заметок:") {
    override fun getDisplayName(item: Note) = item.title
    override fun createItem(): Boolean {
        print("Введите название заметки: ")
        val title = scanner.nextLine().trim()
        if (title.isEmpty()) {
            showError("Название не может быть пустым")
            return true
        }

        print("Введите содержание заметки: ")
        val content = scanner.nextLine().trim()
        if (content.isEmpty()) {
            showError("Содержание не может быть пустым")
            return true
        }

        notes.add(Note(title, content))
        println("Заметка '$title' создана")
        return true
    }

    override fun selectItem(item: Note): Boolean {
        println("\n=== ${item.title} ===")
        println(item.content)
        println("\nНажмите Enter для возврата")
        scanner.nextLine()
        return true
    }
}