class ArchiveMenu(private val archive: Archive) : Menu<Note>("Список заметок в архиве '${archive.name}'") {
    override fun getItems() = archive.notes
    override fun createItem() = archive.createNote()

    override fun handleItemSelected(item: Note) {
        println("\nЗаметка: ${item.title}")
        println("Содержание:\n${item.content}")
        println("\nНажмите Enter чтобы вернуться...")
        readlnOrNull()
    }
}