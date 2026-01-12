import java.util.Scanner

val archives = mutableListOf<Archive>()
val scanner = Scanner(System.`in`)

fun main() {
    val archiveMenu = Menu("Архивы")

    archiveMenu.addOption("Создать архив") {
        createArchive()
    }

    archiveMenu.addOption("Выбрать архив") {
        chooseArchive()
    }

    archiveMenu.show()
}

fun createArchive() {
    println("\n=== Создание архива ===")
    print("Введите название архива: ")
    val name = scanner.nextLine().trim()

    if (name.isEmpty()) {
        println("Ошибка: название не может быть пустым")
        return
    }

    archives.add(Archive(name))
    println("Архив '$name' создан")
}

fun chooseArchive() {
    selectFromList(
        title = "Выбор архива",
        items = archives,
        itemToString = { it.name },
        onSelect = { archive ->
            showNotesMenu(archive)
        }
    )
}

fun showNotesMenu(archive: Archive) {
    val notesMenu = Menu("Заметки архива: ${archive.name}")

    notesMenu.addOption("Создать заметку") {
        createNote(archive)
    }

    notesMenu.addOption("Просмотреть заметки") {
        chooseNote(archive)
    }

    notesMenu.show()
}

fun createNote(archive: Archive) {
    println("\n=== Создание заметки ===")

    print("Введите заголовок заметки: ")
    val title = scanner.nextLine().trim()

    if (title.isEmpty()) {
        println("Ошибка: заголовок не может быть пустым")
        return
    }

    print("Введите содержание заметки: ")
    val content = scanner.nextLine().trim()

    if (content.isEmpty()) {
        println("Ошибка: содержание не может быть пустым")
        return
    }

    archive.notes.add(Note(title, content))
    println("Заметка '$title' создана")
}

fun chooseNote(archive: Archive) {
    selectFromList(
        title = "Выбор заметки",
        items = archive.notes,
        itemToString = { it.title },
        onSelect = { note ->
            showNoteContent(note)
        }
    )
}

fun showNoteContent(note: Note) {
    println("\n=== ${note.title} ===")
    println(note.content)
    println("\nНажмите Enter для возврата...")
    scanner.nextLine()
}

fun <T> selectFromList(
    title: String,
    items: List<T>,
    itemToString: (T) -> String,
    onSelect: (T) -> Unit
) {
    if (items.isEmpty()) {
        println("Список пуст")
        return
    }

    println("\n=== $title ===")
    items.forEachIndexed { index, item ->
        println("$index. ${itemToString(item)}")
    }
    println("${items.size}. Назад")

    print("Выберите пункт: ")
    val input = scanner.nextLine()

    if (input == items.size.toString()) {
        return
    }

    val choice = input.toIntOrNull()
    if (choice == null || choice !in items.indices) {
        println("Ошибка: введите число от 0 до ${items.size - 1}")
        return
    }

    onSelect(items[choice])
}