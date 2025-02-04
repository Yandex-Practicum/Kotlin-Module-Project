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
            noteMenu.addOption("Назад") { returnToMenu = true }

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
        val name = backInput("название для нового архива")
        if (name == null) return

        archives.add(Archive(name))
        println("Архив '$name' создан.")
    }

    private fun createNoteInArchive(archive: Archive) {
        val title = backInput("заголовок заметки")
        if (title == null) return

        val content = backInput("содержание заметки")
        if (content == null) return

        archive.notes.add(Note(title, content))
        println("Заметка '$title' добавлена в архив '${archive.name}'.")
    }

    private fun backInput(prompt: String, exitKeyword: String = "назад"): String? {
        var input: String
        while (true) {
            println("\nВведите $prompt (или введите НАЗАД для возврата):")
            input = scanner.nextLine().trim()
            if (input.lowercase() == exitKeyword) {
                return null
            }
            if (input.isNotEmpty()) {
                return input
            } else {
                println("Ошибка: пустое поле! Попробуйте снова.")
            }
        }
    }
}
