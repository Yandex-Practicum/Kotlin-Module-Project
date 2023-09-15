class Note(val name: String, val text: String)

val archives = mutableListOf<Archive>()

val createArchiveItem = Pair("Создать архив", ::createArchive)
val viewArchivesItem = Pair("Просмотреть архивы", ::viewArchives)

val mainMenu = Menu(listOf(createArchiveItem, viewArchivesItem))

fun addNoteToArchive(archive: Archive) {
    println("Введите название заметки:")
    val noteName = readLine()?.trim()
    if (noteName.isNullOrEmpty()) {
        println("Название заметки не может быть пустым")
        return
    }

    println("Введите текст заметки:")
    val noteText = readLine()?.trim()
    if (noteText.isNullOrEmpty()) {
        println("Текст заметки не может быть пустым")
        return
    }

    val note = Note(noteName, noteText)
    archive.notes.add(note)
    println("Заметка \"$noteName\" успешно добавлена в архив")
}

fun viewNotesInArchive(archive: Archive) {
    if (archive.notes.isEmpty()) {
        println("В архиве нет заметок")
        return
    }

    println("Список заметок в архиве \"${archive.name}\":")
    for ((index, note) in archive.notes.withIndex()) {
        println("${index + 1}. ${note.name}")
    }
    println("0. Назад")

    when (val input = readLine()?.toIntOrNull()) {
        0 -> return
        in 1..archive.notes.size -> {
            val selectedNote = archive.notes[input!! - 1]
            println("Заметка \"${selectedNote.name}\":")
            println(selectedNote.text)
        }

        else -> {
            println("Пожалуйста, введите корректное значение")
        }
    }
}