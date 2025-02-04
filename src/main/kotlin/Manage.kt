import java.util.Scanner

class Manage {
    private val archives = mutableListOf<Archive>()
    private val scanner = Scanner(System.`in`)

    fun start() {
        var running = true
        while (running) {
            val archiveMenu = Menu("Выбор архива")
            archiveMenu.addOption("Создать архив") { createArchive() }
            archives.forEachIndexed { index, archive ->
                archiveMenu.addOption(archive.name) { chooseArchive(index) }
            }
            archiveMenu.addOption("Выход") { running = false }

            archiveMenu.show()
            archiveMenu.handleInput()
        }
    }

    private fun chooseArchive(index: Int) {
        val archive = archives[index]
        var returnToMenu = false

        while (!returnToMenu) {
            val noteMenu = Menu("Выбор заметки из архива: ${archive.name}")
            noteMenu.addOption("Создать заметку") { createNoteInArchive(archive) }
            archive.notes.forEachIndexed { noteIndex, note ->
                noteMenu.addOption(note.title) { viewNote(archive, note) }
            }
            noteMenu.addOption("Назад") {
                returnToMenu = true
            }

            noteMenu.show()
            noteMenu.handleInput()
        }
    }

    private fun viewNote(archive: Archive, note: Note) {
        println("\nЗаметка: ${note.title}")
        println("Содержание: ${note.content}")
        println("Нажмите любую клавишу для возврата...")
        scanner.nextLine()
    }

    private fun createArchive() {
        var name: String
        while (true) {
            println("\nВведите название для нового архива (или введите НАЗАД для возврата):")
            name = scanner.nextLine().trim()

            if (name.lowercase() == "назад") {
                println("Возврат в главное меню.")
                return
            }

            if (name.isNotEmpty()) {
                archives.add(Archive(name))
                println("Архив '$name' создан.")
                break
            } else {
                println("Ошибка: пустое поле! Попробуйте снова.")
            }
        }
    }

    private fun createNoteInArchive(archive: Archive) {
        var title: String
        var content: String

        while (true) {
            println("\nВведите заголовок заметки (или введите НАЗАД для возврата):")
            title = scanner.nextLine().trim()

            if (title.lowercase() == "назад") {
                println("Возврат в меню архива.")
                return
            }

            if (title.isNotEmpty()) {
                break
            } else {
                println("Ошибка: пустое поле! Попробуйте снова.")
            }
        }

        while (true) {
            println("Введите содержание заметки (или введите НАЗАД для возврата):")
            content = scanner.nextLine().trim()

            if (content.lowercase() == "назад") {
                println("Возврат в меню архива.")
                return
            }

            if (content.isNotEmpty()) {
                break
            } else {
                println("Ошибка: пустое поле! Попробуйте снова.")
            }
        }
        archive.notes.add(Note(title, content))
        println("Заметка '$title' добавлена в архив '${archive.name}'.")
    }
}