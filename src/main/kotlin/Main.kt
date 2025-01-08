import kotlin.system.exitProcess

val archives = mutableListOf<Archive>()

fun main() {
    while (true) {
        mainMenu()
    }
}

// Главное меню
fun mainMenu() {
    buildMenu(
        title = "Список архивов",
        items = archives,
        itemDescription = { archive -> "Открыть архив: ${archive.name}" },
        onSelect = { archive -> archiveMenu(archive) },
        additionalOptions = listOf("Создать архив" to ::createArchive, "Выход" to { exitProcess(0) })
    )
}

// Меню конкретного архива
fun archiveMenu(archive: Archive) {
    buildMenu(
        title = "Архив: ${archive.name}",
        items = archive.notes,
        itemDescription = { note -> "Открыть заметку: ${note.title}" },
        onSelect = { note -> viewNoteMenu(note) },
        additionalOptions = listOf("Создать заметку" to { createNoteMenu(archive) }, "Назад" to {})
    )
}

// Создание нового архива
fun createArchive() {
    println("Введите название архива:")
    val name = readLine()?.trim() ?: ""
    if (name.isEmpty()) {
        println("Название архива не может быть пустым.")
        return
    }
    archives.add(Archive(name))
    println("Архив '$name' создан.")
}

// Создание новой заметки
fun createNoteMenu(archive: Archive) {
    println("Введите название заметки:")
    val title = readLine()?.trim() ?: ""
    if (title.isEmpty()) {
        println("Название заметки не может быть пустым.")
        return
    }

    println("Введите содержание заметки:")
    val content = readLine()?.trim() ?: ""
    if (content.isEmpty()) {
        println("Содержание заметки не может быть пустым.")
        return
    }

    archive.notes.add(Note(title, content))
    println("Заметка '$title' добавлена в архив '${archive.name}'.")
}

// Просмотр заметки
fun viewNoteMenu(note: Note) {
    println("\nНазвание: ${note.title}")
    println("Содержание: ${note.content}")
    println("Нажмите Enter, чтобы вернуться назад.")
    readLine()
}
