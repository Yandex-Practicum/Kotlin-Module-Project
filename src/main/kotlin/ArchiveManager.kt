object ArchiveManager {
    private val archives = mutableListOf<Archive>()

    fun showMenu() {
        MainFuncs.displayMenu(
            "Меню архивов",
            generateOptions(),
            generateActions(),
            { println("Выход из программы.") }
        )
    }

    private fun generateOptions(): Array<String> {
        val options = mutableListOf("Создать архив")
        options.addAll(archives.map { it.name })
        return options.toTypedArray()
    }

    private fun generateActions(): Array<() -> Unit> {
        val actions = mutableListOf<() -> Unit>({ createArchive() })
        actions.addAll(archives.map { archive -> { navigateToArchive(archive) } })
        return actions.toTypedArray()
    }

    private fun createArchive() {
        println("Введите название нового архива:")
        val input = readLine()?.trim()

        if (!input.isNullOrEmpty()) {
            archives.add(Archive(input, mutableListOf()))
            println("Архив '$input' успешно создан.")
            ArchiveManager.showMenu()
        } else {
            println("Название архива не может быть пустым.")
        }
    }

    private fun navigateToArchive(archive: Archive) {
            NoteManager.showMenu(archive)


    }
}
