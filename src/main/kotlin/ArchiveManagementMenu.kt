import java.util.Scanner

class ArchiveManagementMenu(
    private val archiveManager: ArchiveManager,
    private val scanner: Scanner
) {
    private var archiveName = ""

    fun show() {
        println("Введите название архива для управления:")
        val archiveName = scanner.nextLine()

        if (!validateInput(archiveName, "Имя архива")) return

        this.archiveName = archiveName

        while (true) {
            println("Выберите действие:")
            println("1 — Добавить заметку")
            println("2 — Просмотреть заметки")
            println("3 — Выйти из меню архива")

            val choice = scanner.nextLine()

            when (choice) {
                "1" -> addNote()
                "2" -> viewNotes()
                "3" -> return
                else -> println("Неверный выбор. Попробуйте снова.")
            }
        }
    }

    private fun addNote() {
        println("Введите заголовок заметки:")
        val title = scanner.nextLine()

        println("Введите текст заметки:")
        val text = scanner.nextLine()

        if (!validateInput(title, "Заголовок заметки")) return
        if (!validateInput(text, "Текст заметки")) return

        if (archiveManager.addNoteToArchive(archiveName, title, text)) {
            println("Заметка успешно добавлена!")
        } else {
            println("Не удалось добавить заметку.")
        }
    }

    private fun viewNotes() {
        val notes = archiveManager.getNotes(archiveName)
        if (notes.isEmpty()) {
            println("В этом архиве пока нет заметок. Хотите добавить новую?")
            return
        }

        println("Список заметок:")
        notes.forEach { note ->
            println("Заголовок: ${note.title}")
            println("Текст: ${note.text}")
        }
    }

    private fun validateInput(input: String, description: String): Boolean {
        if (input.isEmpty()) {
            println("Ошибка: $description не может быть пустым.")
            return false
        }
        return true
    }
}