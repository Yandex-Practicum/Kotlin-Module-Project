import java.util.Scanner

class ArchiveManagementMenu(
    private val archiveManager: ArchiveManager,
    private val scanner: Scanner
) {
    private var archiveName = ""

    fun show() {
        println("Введите название архива для управления:")
        val archiveName = scanner.nextLine()

        // Проверка: имя архива не может быть пустым
        if (archiveName.isNullOrEmpty()) {
            println("Имя архива не может быть пустым. Пожалуйста, введите корректное имя.")
            return
        }

        // Проверяем, существует ли архив
        if (archiveName !in archiveManager.getArchiveNames()) {
            println("Архив не найден. Возвращаемся в главное меню.")
            return
        }

        this.archiveName = archiveName

        while (true) {
            println("\nВыберите действие:")
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


        if (title.isNullOrEmpty()) {
            println("Заголовок заметки не может быть пустым.")
            return
        }


        if (text.isNullOrEmpty()) {
            println("Текст заметки не может быть пустым.")
            return
        }


        if (archiveManager.addNoteToArchive(archiveName, title, text)) {
            println("Заметка успешно добавлена!")
        } else {
            println("Не удалось добавить заметку.")
        }
    }

    private fun viewNotes() {
        val notes = archiveManager.getNotes(archiveName)
        if (notes.isEmpty()) {
            println("Заметок нет.")
            return
        }

        println("\nСписок заметок:")
        notes.forEach { note ->
            println("Заголовок: ${note.title}")
            println("Текст: ${note.text}\n")
        }
    }
}