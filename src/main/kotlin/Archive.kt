class Archive(val name: String) {
    val notes = mutableListOf<Note>()

    init {
        require(name.isNotBlank()) { "Название архива не может быть пустым." }
    }

    fun addNote(note: Note) {
        notes.add(note)
    }
}
class MainMenu(private val noteManager: NoteManager) {
    fun show() {
        while (true) {
            println("Главное меню:")
            println("1. Создать архив")
            println("2. Просмотреть архивы")
            println("0. Выход")

            when (readLine()) {
                "1" -> createArchive()
                "2" -> viewArchives()
                "0" -> return
                else -> println("Некорректный выбор. Пожалуйста, попробуйте снова.")
            }
        }
    }

    private fun createArchive() {
        while (true) {
            print("Введите название архива: ")
            val name = readLine() ?: ""
            try {
                noteManager.addArchive(Archive(name))
                println("Архив создан! Нажмите любую клавишу для продолжения...")
                readLine()
                return
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun viewArchives() {
        if (noteManager.archives.isEmpty()) {
            println("Нет доступных архивов.")
            return
        }

        println("Доступные архивы:")
        noteManager.archives.forEachIndexed { index, archive ->
            println("${index + 1}. ${archive.name}")
        }

        print("Введите номер архива для просмотра заметок (или 0 для выхода): ")
        val input = readLine()?.toIntOrNull()
        if (input == 0) return
        if (input != null && input in 1..noteManager.archives.size) {
            viewNotesInArchive(input - 1)
        } else {
            println("Некорректный номер архива.")
        }
    }

    private fun viewNotesInArchive(archiveIndex: Int) {
        while (true) {
            noteManager.viewNotesInArchive(archiveIndex)
            println("Хотите добавить новую заметку в архив? (да/нет)")
            when (readLine()?.toLowerCase()) {
                "да" -> addNoteToArchive(archiveIndex)
                "нет" -> return
                else -> println("Некорректный ввод. Пожалуйста, введите 'да' или 'нет'.")
            }
        }
    }

    private fun addNoteToArchive(archiveIndex: Int) {
        while (true) {
            print("Введите заголовок заметки: ")
            val title = readLine() ?: ""
            print("Введите содержимое заметки: ")
            val content = readLine() ?: ""

            try {
                val note = Note(title, content)
                noteManager.archives[archiveIndex].addNote(note)
                println("Заметка добавлена! Нажмите любую клавишу для продолжения...")
                readLine()
                return
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
