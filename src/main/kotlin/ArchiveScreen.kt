fun openArchiveMenu() {
    while (true) {
        val menuItems = mutableListOf<MenuItem>()
        menuItems.add(MenuItem("Создать архив") { createArchive() })

        archiveList.forEach { archive ->
            menuItems.add(MenuItem("Открыть архив: ${archive.name}") {
                openNoteMenu(archive)
            })
        }

        menuItems.add(MenuItem("Выход из программы") {
            println("До свидания!")
            System.exit(0)
        })

        val archiveMenu = MenuProcessing("ГЛАВНОЕ МЕНЮ (СПИСОК АРХИВОВ)", menuItems)
        val shouldContinue = archiveMenu.show()
        if (!shouldContinue) break
    }
}

fun createArchive() {
    val name = readNonEmptyString("\nВведите название для нового архива:")
    val newArchive = Archive(name)
    archiveList.add(newArchive)
    println("Успешно: Архив '$name' создан!")
}