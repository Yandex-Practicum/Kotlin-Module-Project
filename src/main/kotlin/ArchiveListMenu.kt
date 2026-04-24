import java.util.Scanner

class ArchiveManagementMenu(
    private val archiveManager: ArchiveManager,
    private val scanner: Scanner
) {
    private var archiveName = ""
    fun show() {
        println("Введите название архива для управления:")
        val archiveName = scanner.nextLine()

        if (archiveName !in archiveManager.getArchiveNames()) {
            println("Архив не найден. Возвращаемся в главное меню.")
            return
        }

        this.archiveName = archiveName

        while (true) {
            println("\n=== Управление архивом '$archiveName' ===")
            println("1. Добавить заметку")
            println("2. Просмотреть заметки")
            println("3. Редактировать заметку")
            println("4. Удалить заметку")
            println("5. Вернуться в главное меню")

            val choice = scanner.nextLine()
            when (choice) {
                "1" -> addNote()
                "2" -> viewNotes()
                "3" -> editNote()
                "4" -> deleteNote()
                "5" -> return // Выход из цикла и возврат в главное меню
                else -> println("Неправильный выбор. Попробуйте снова.")
            }
        }
    }


    private fun addNote() {
        println("Введите заголовок заметки:")
        val title = scanner.nextLine()

        println("Введите текст заметки:")
        val text = scanner.nextLine()

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
        notes.forEachIndexed { index, note ->
            println("$index. Заголовок: ${note.title}")
            println("  Текст: ${note.text}\n")
        }
    }


    private fun editNote() {
        println("Функция редактирования заметки пока не реализована.")
    }


    private fun deleteNote() {
        println("Функция удаления заметки пока не реализована.")
    }
}