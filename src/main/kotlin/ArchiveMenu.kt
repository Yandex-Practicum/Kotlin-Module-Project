class ArchiveMenu : Menu("Список архивов") {
    private val archives = mutableListOf<Archive>()

    override fun show() {
        runMenu(
            items = archives,
            getItemName = { it.name },
            onSelect = { archive -> NoteListMenu(archive).show() },
            onCreate = {
                val name = readNonEmptyString("Введите название архива:")
                archives.add(Archive(name))
                println("Архив '$name' создан.")
            },
            exitText = "Выход из программы"
        )
    }
}