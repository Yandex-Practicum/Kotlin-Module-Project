fun archiveMenu() {
    while (true) {
        println("\nСписок архивов:")
        println("0. Создать архив")
        archives.forEachIndexed { i, archive ->
            println("${i + 1}. ${archive.name}")
        }
        println("${archives.size + 1}. Выход")

        val input = readlnOrNull()?.toIntOrNull()
        when {
            input == 0 -> createArchive()
            input != null && input in 1..archives.size -> noteMenu(archives[input - 1])
            input == archives.size + 1 -> return
            else -> println("Некорректный ввод")
        }
    }
}

fun createArchive() {
    println("Введите название архива:")
    val name = readlnOrNull()?.takeIf { it.isNotBlank() } ?: run {
        println("Название не может быть пустым")
        return
    }
    archives.add(Archive(name))
    println("Архив '$name' создан")
}
fun createNote(archive: Archive) {
    println("Введите заголовок заметки:")
    val title = readlnOrNull()?.takeIf { it.isNotBlank() } ?: run {
        println("Заголовок не может быть пустым")
        return
    }
    println("Введите текст заметки:")
    val text = readlnOrNull()?.takeIf { it.isNotBlank() } ?: run {
        println("Текст не может быть пустым")
        return
    }
    archive.notes.add(Note(title, text))
    println("Заметка '$title' добавлена")
}
fun noteMenu(archive: Archive) {
    while (true) {
        println("\nАрхив: ${archive.name}")
        println("0. Создать заметку")
        archive.notes.forEachIndexed { i, note ->
            println("${i + 1}. ${note.title}")
        }
        println("${archive.notes.size + 1}. Назад")

        val input = readlnOrNull()?.toIntOrNull()
        when {
            input == 0 -> createNote(archive)
            input != null && input in 1..archive.notes.size -> showNote(archive.notes[input - 1])
            input == archive.notes.size + 1 -> return
            else -> println("Некорректный ввод")
        }
    }
}
fun showNote(note: Note) {
    println("\n=== ${note.title} ===")
    println(note.text)
    println("\nНажмите Enter для возврата")
    readlnOrNull()
}