class ArchiveMenu {
    private val archives = mutableListOf<Archive>()

    fun show() {
        Menu("\nСписок архивов:", "Выход") {
            val items = mutableListOf(MenuItem("Создать архив") { createArchive() })
            archives.forEach { archive ->
                items.add(MenuItem(archive.title) { NoteMenu(archive).show() })
            }
            items
        }.show()
    }

    private fun createArchive() {
        val title = Menu.readNonEmptyLine("Введите название архива: ")
        archives.add(Archive(title))
        println("Архив \"$title\" создан.")
    }
}
