class ArchiveMenu(archives: List<Archive>) : Menu<Archive>(archives, "Список архивов:") {
    override fun getDisplayName(item: Archive) = item.name
    override fun createItem(): Boolean {
        print("Введите название архива: ")
        val name = scanner.nextLine().trim()
        when {
            name.isEmpty() -> showError("Название не может быть пустым")
            else -> {
                items as MutableList
                items.add(Archive(name))
                println("Архив '$name' создан")
            }
        }
        return true
    }

    override fun selectItem(item: Archive): Boolean {
        NoteMenu(item.notes).show()
        return true
    }
}