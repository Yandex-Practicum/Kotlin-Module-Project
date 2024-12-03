data class Note(val title: String, val content: String)

class Archive(val name: String) {
    val notes = mutableListOf<Note>()
}

class NoteManager {
    val archives = mutableListOf<Archive>()

    fun addArchive(archive: Archive) {
        archives.add(archive)
    }
}


fun main() {
    val noteManager = NoteManager()
    val mainMenu = MainMenu(noteManager)
    mainMenu.show()
}

class MainMenu(private val noteManager: NoteManager) {
    fun show() {
        while (true) {
            println("Главное меню:")
            println("1. Выбор архива")
            println("2. Создание архива")
            println("0. Выход")

            when (readLine()) {
                "1" -> {
                    val archiveMenu = ArchiveMenu(noteManager)
                    archiveMenu.show()
                }
                "2" -> {
                    val createArchiveMenu = CreateArchiveMenu(noteManager)
                    createArchiveMenu.show()
                }
                "0" -> return
                else -> println("Неверный выбор. Попробуйте снова.")
            }
        }
    }
}

class ArchiveMenu(private val noteManager: NoteManager) {
    fun show() {
        while (true) {
            println("Выбор архива:")
            noteManager.archives.forEachIndexed { index, archive ->
                println("${index + 1}. ${archive.name}")
            }
            println("0. Назад")

            when (readLine()) {
                "0" -> return
                else -> {
                    val index = readLine()?.toIntOrNull()
                    if (index != null && index in 1..noteManager.archives.size) {
                        val noteMenu = NoteMenu(noteManager.archives[index - 1])
                        noteMenu.show()
                    } else {
                        println("Неверный выбор. Попробуйте снова.")
                    }
                }
            }
        }
    }
}

class CreateArchiveMenu(private val noteManager: NoteManager) {
    fun show() {
        println("Создание архива:")
        print("Введите название архива: ")
        val name = readLine() ?: ""
        noteManager.addArchive(Archive(name))
        println("Архив создан! Нажмите любую клавишу для продолжения...")
        readLine()
    }
}

class NoteMenu(private val archive: Archive) {
    fun show() {
        while (true) {
            println("Заметки в архиве '${archive.name}':")
            archive.notes.forEachIndexed { index, note ->
                println("${index + 1}. ${note.title}")
            }
            println("0. Назад")
            println("2. Создать заметку")

            when (readLine()) {
                "0" -> return
                "2" -> {
                    val createNoteMenu = CreateNoteMenu(archive)
                    createNoteMenu.show()
                }
                else -> {
                    val index = readLine()?.toIntOrNull()
                    if (index != null && index in 1..archive.notes.size) {
                        val noteDisplayMenu = NoteDisplayMenu(archive.notes[index - 1])
                        noteDisplayMenu.show()
                    } else {
                        println("Неверный выбор. Попробуйте снова.")
                    }
                }
            }
        }
    }
}

class CreateNoteMenu(private val archive: Archive) {
    fun show() {
        println("Создание заметки:")
        print("Введите заголовок: ")
        val title = readLine() ?: ""
        print("Введите текст заметки: ")
        val content = readLine() ?: ""

        archive.notes.add(Note(title, content))

        println("Заметка создана! Нажмите любую клавишу для продолжения...")
        readLine()
    }
}

class NoteDisplayMenu(private val note: Note) {
    fun show() {
        println("Заметка: ${note.title}")
        println(note.content)
        println("Нажмите любую клавишу для возвращения...")
        readLine()
    }
}
