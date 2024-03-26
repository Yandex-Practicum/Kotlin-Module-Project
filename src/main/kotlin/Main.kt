import java.io.File

fun main() {
    val archivesDirectory = File("archives")
    if (!archivesDirectory.exists()) {
        archivesDirectory.mkdirs()
    }

    println("Добро пожаловать!")

    var exit = false
    while (!exit) {
        printMainMenu()
        val choice = UserChoice(1, 4)

        when (choice) {
            1 -> createArchive()
            2 -> selectArchive()
            3 -> {
                println("До свидания!")
                exit = true
            }
        }
    }
}

fun printMainMenu() {
    println("Главное меню:")
    println("1. Создать архив")
    println("2. Выбрать архив")
    println("3. Выход из приложения")
}

fun UserChoice(min: Int, max: Int): Int {
    var choice: Int? = null
    while (choice == null) {
        val input = readLine()
        if (input != null && input.matches(Regex("\\d+"))) {
            choice = input.toInt()
            if (choice !in min..max) {
                println("Выберите корректный пункт.")
                choice = null
            }
        } else {
            println("Введите цифру.")
        }
    }
    return choice
}

fun selectItemFromList(items: Array<String>): Int {
    println("Выберите один из пунктов:")
    items.forEachIndexed { index, item ->
        println("${index + 1}. $item")
    }

    var choice: Int? = null
    while (choice == null) {
        val input = readLine()
        if (input != null && input.matches(Regex("\\d+"))) {
            choice = input.toInt()
            if (choice !in 1..items.size) {
                println("Выберите корректный пункт.")
                choice = null
            }
        } else {
            println("Введите цифру.")
        }
    }
    return choice
}

fun selectArchive() {  // Выбор архива
    val archivesDirectory = File("archives")
    val archiveFiles = archivesDirectory.listFiles()

    val archiveNames = archiveFiles?.map { it.nameWithoutExtension }?.toTypedArray() ?: arrayOf()
    val menuItems = archiveNames + "Создать архив" + "Назад"
    val choice = selectItemFromList(menuItems)

    when (choice) {
        in 1..archiveNames.size -> selectNoteInArchive(archiveFiles!![choice - 1])
        archiveNames.size + 1 -> createArchive()
        archiveNames.size + 2 -> return // Назад
    }
}

fun createArchive() { // Создание архива
    println("Введите название архива:")
    var archiveName = readLine()?.trim()

    while (archiveName.isNullOrBlank()) {
        println("Имя архива не может быть пустым ")
        archiveName = readLine()?.trim()
    }

    val archiveDirectory = File("archives", archiveName)
    if (!archiveDirectory.exists()) {
        archiveDirectory.mkdirs()
        println("Архив '$archiveName' успешно создан.")
    } else {
        println("Архив с именем '$archiveName' уже существует.")
    }
}


fun selectNoteInArchive(archive: File) { // Выбор заметок
    var exit = false
    while (!exit) {
        println("Список заметок в архиве '${archive.nameWithoutExtension}':")
        val noteFiles = archive.listFiles()

        val noteNames = noteFiles?.map { it.nameWithoutExtension }?.toTypedArray() ?: arrayOf()
        val menuItems = noteNames + "Создать заметку" + "Назад"
        val choice = selectItemFromList(menuItems)

        when {
            choice in 1..noteNames.size -> showNoteContent(noteFiles!![choice - 1])
            choice == noteNames.size + 1 -> createNoteInArchive(archive)
            choice == noteNames.size + 2 -> exit = true // Назад
        }
    }
    selectArchive()
}
fun createNoteInArchive(archive: File) {   // Создание заметки в архиве
    println("Введите название новой заметки:")
    var noteName = readLine()?.trim()

    while (noteName.isNullOrBlank()) {
        println("Имя заметки не может быть пустым ")
        noteName = readLine()?.trim()
    }

    println("Введите содержание заметки:")
    var noteContent = readLine()?.trim()

    while (noteContent.isNullOrEmpty()) {
        println("Содержание заметки не может быть пустым ")
        noteContent = readLine()?.trim()
    }

    val newNoteFile = File(archive, "$noteName.txt")
    if (!newNoteFile.exists()) {
        newNoteFile.writeText(noteContent)
        println("Заметка '$noteName' успешно создана в архиве '${archive.nameWithoutExtension}'.")
    } else {
        println("Заметка с именем '$noteName' уже существует в архиве '${archive.nameWithoutExtension}'.")
    }
}
fun showNoteContent(noteFile: File) {  // Вывод содержимого заметки
    println("Текст заметки '${noteFile.nameWithoutExtension}':")
    println(noteFile.readText())

    println("Нажмите Enter, чтобы вернуться назад.")
    readLine()
}