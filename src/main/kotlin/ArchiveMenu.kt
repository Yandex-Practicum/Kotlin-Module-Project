class ArchiveMenu {
    private val archives = mutableListOf<Archive>()

    fun show() {
        println("Добро пожаловать в приложение Заметки!")

        val menu = SelectionMenu(
            title = "СПИСОК АРХИВОВ",
            items = archives,
            itemDisplay = { it.name }
        )

        val shouldContinue = menu.show(
            onItemSelected = { archive ->
                val noteMenu = NoteMenu(archive)
                noteMenu.show()
                true
            },
            onCreate = {
                createArchive()
                true
            }
        )

        if (!shouldContinue) {
            println("Выход из приложения. До свидания!")
        }
    }

    private fun createArchive() {
        val name = SelectionMenu.readInput("Введите название архива: ")
        archives.add(Archive(name))
        println("Архив '$name' успешно создан!")
    }
}
