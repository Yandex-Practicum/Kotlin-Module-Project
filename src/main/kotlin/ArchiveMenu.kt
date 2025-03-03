// Меню работы с заметками в архиве
fun showArchiveMenu(archiveIndex: Int) {
    val archive = archives[archiveIndex]
    val menu = MenuManager("Список заметок:" + if (archive.notes.isNotEmpty()) " ${archive.notes.joinToString { it.title }}" else "")
    menu.addItem("Создать заметку") { createNote(archive) }
    archive.notes.forEachIndexed { index, note ->
        menu.addItem(note.title) { showNote(archive, index) }
    }
    menu.show {
        showMainMenu() // Возврат к списку архивов после выхода
    }
}

// Создание заметки
fun createNote(archive: Archive) {
    val title = readInput("Введите название заметки:") ?: run {
        println("Название заметки не может быть пустым.")
        return
    }
    val content = readInput("Введите текст заметки:") ?: run {
        println("Текст заметки не может быть пустым.")
        return
    }

    archive.notes.add(Note(title, content))
    println("Заметка '$title' создана.")
    showArchiveMenu(archives.indexOf(archive)) // Обновляем меню архива
}

// Просмотр заметки
fun showNote(archive: Archive, noteIndex: Int) {
    val note = archive.notes[noteIndex]
    println("Заметка: ${note.title}")
    println("Текст: ${note.content}")
    println("Нажмите Enter, чтобы вернуться.")
    readLine()
    showArchiveMenu(archives.indexOf(archive)) // Возврат к списку заметок после просмотра
}