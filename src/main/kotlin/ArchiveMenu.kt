class ArchiveMenu(private val archives: MutableList<Archive>) : Menu<Archive>() {
    override val items: List<Archive> = archives
    override val createItemText: String = "Создать архив"
    override val menuTitle: String = "Список архивов"
    override val exitText: String = "Выход"

    override fun displayItem(item: Archive): String = item.name

    override fun onCreateItem() {
        println("\nСоздание архива")
        val name = readNonEmptyInput("Введите название архива: ")
        archives.add(Archive(name))
        println("Архив '$name' создан!")
    }

    override fun onItemSelected(item: Archive) {
        NoteMenu(item.notes, item.name).show()
    }
}