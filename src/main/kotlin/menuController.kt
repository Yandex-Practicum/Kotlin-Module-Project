import kotlin.system.exitProcess

class MenuController {
    private val archives = mutableListOf<Archive>()

    fun start() {
        showArchiveMenu()
      }

    private fun showArchiveMenu() {
        val options = mutableListOf<Pair<String, () -> Unit>>()
        options += "Создать архив" to ::createArchive
        archives.forEach { archive ->
            options += archive.name to { showNoteMenu(archive) }
        }
        options += "Выход из программы" to { exitProcess(0) }
        Menu("Список архивов", options).show()
        showArchiveMenu()
    }

    private fun createArchive() {
        println("Введите имя архива:")
        val name = readLine()?.trim()
        if (name.isNullOrEmpty()) {
            println("Имя не может быть пустым.")
        } else {
            archives.add(Archive(name))
            println("Архив$name создан.")
        }
    }

    private fun showNoteMenu(archive: Archive) {
        val options = mutableListOf<Pair<String, () -> Unit>>()
        options += "Создать заметку" to { createNote(archive) }
        archive.notes.forEach { note ->
            options += note.title to { showNote(note) }
        }
        options += "Назад" to ::start

        Menu("Архив: ${archive.name}", options).show()
        showNoteMenu(archive)
    }

    private fun createNote(archive: Archive) {
        println("Введите название заметки:")
        val title = readLine()?.trim()
        if (title.isNullOrEmpty()) {
            println("Название не может быть пустым.")
            return
        }

        println("Введите содержимое заметки:")
        val content = readLine()?.trim()
        if (content.isNullOrEmpty()) {
            println("Содержимое не может быть пустым.")
            return
        }

        archive.notes.add(Note(title, content))
        println("Заметка $title добавлена.")
    }

    private fun showNote(note: Note) {
        println("Заметка: ${note.title}")
        println(note.content)
        println("\nНажмите Enter для возврата")
        readLine()
    }
}