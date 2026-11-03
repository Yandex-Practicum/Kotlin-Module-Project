fun openNoteMenu(archive: Archive) {
    while (true) {
        val menuItems = mutableListOf<MenuItem>()

        val currentArchive = archiveList.find { it.name == archive.name } ?: archive
        menuItems.add(MenuItem("Создать заметку") { createNote(currentArchive) })

        currentArchive.notes.forEach { note ->
            menuItems.add(MenuItem("Посмотреть заметку: ${note.title}") {
                showNoteContent(note)
            })
        }

        menuItems.add(MenuItem("Назад в главное меню") { println("Возвращаемся...") })

        val noteMenu = MenuProcessing("АРХИВ [${archive.name}] -> СПИСОК ЗАМЕТОК", menuItems)
        val shouldContinue = noteMenu.show()
        if (!shouldContinue) break
    }
}

fun createNote(archive: Archive) {
    val title = readNonEmptyString("\nВведите заголовок заметки:")
    val content = readNonEmptyString("Введите текст заметки:")

    val newNote = Note(title, content)

    val index = archiveList.indexOfFirst { it.name ==archive.name }

    if (index != -1) {
        val updatedArchive = archiveList[index].copy(notes = archiveList[index].notes + newNote)
        archiveList[index] = updatedArchive
        println("Успешно: Заметка '${title}' добавлена в архив '${archive.name}'!")
    } else {
        println("Ошибка: Архив не найден.")
    }
}

fun showNoteContent(note: Note) {
    println("\n=== ПРОСМОТР ЗАМЕТКИ ===")
    println("Заголовок: ${note.title}")
    println("Текст: ${note.content}")
    println("========================")
    println("Нажмите Enter, чтобы вернуться назад...")
    scanner.nextLine()
}