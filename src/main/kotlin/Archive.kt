class Archive(val name: String, val notes: MutableList<Note> = mutableListOf())

fun createArchive() {
    println("Введите название архива:")
    val archiveName = readLine()?.trim()
    if (archiveName.isNullOrEmpty()) {
        println("Название архива не может быть пустым")
        return
    }
    val archive = Archive(archiveName)
    archives.add(archive)
    println("Архив \"$archiveName\" успешно создан")
}

    fun viewArchives() {
        if (archives.isEmpty()) {
            println("Нет доступных архивов")
            return
        }

        println("Список архивов:")
        for ((index, archive) in archives.withIndex()) {
            println("${index + 1}. ${archive.name}")
        }
        println("0. Назад")

        when (val input = readLine()?.toInt()) {
            0 -> {
                return
            }

            in 1..archives.size -> {
                val selectedArchive = archives[input!! - 1]
                val archiveMenuItems = listOf(
                    Pair("Добавить заметку") { addNoteToArchive(selectedArchive) },
                    Pair("Просмотреть заметки") { viewNotesInArchive(selectedArchive) }
                )
                val archiveMenu = Menu(archiveMenuItems)
                archiveMenu.show()
            }

            else -> {
                println("Пожалуйста, введите корректное значение")
            }
        }
    }







