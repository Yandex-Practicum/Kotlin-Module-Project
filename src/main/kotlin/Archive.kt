import java.util.Scanner

class Archive(val name: String) {
    private val notes = mutableListOf<Note>()

    fun viewNotes(scanner: Scanner) {
        while (true) {
            println("Выберите действие:")
            println("0. Вернуться")
            println("1. Добавить заметку")
            println("2. Просмотреть заметки")
            when (scanner.nextLine().trim()) {
                "0" -> return
                "1" -> addNote(scanner)
                "2" -> listNotes(scanner)
                else -> println("Неверный ввод, попробуйте снова.")
            }
        }
    }

    private fun addNote(scanner: Scanner) {
        println("Введите заголовок заметки (или введите '0' для отмены):")
        val title = scanner.nextLine().trim()
        if (title == "0") {
            return
        }
        if (title.isEmpty()) {
            println("Заголовок заметки не может быть пустым.")
            return
        }
        println("Введите содержание заметки (или введите '0' для отмены):")
        val content = scanner.nextLine().trim()
        if (content == "0") {
            return
        }
        if (content.isEmpty()) {
            println("Содержание заметки не может быть пустым.")
            return
        }
        notes.add(Note(title, content))
        println("Заметка добавлена.")
    }

    private fun listNotes(scanner: Scanner) {
        if (notes.isEmpty()) {
            println("Нет доступных заметок.")
            return
        }
        println("Выберите заметку для открытия или введите '0' для возврата:")
        println("0. Вернуться")
        for ((index, note) in notes.withIndex()) {
            println("${index + 1}. ${note.title}")
        }
        val input = scanner.nextLine().trim().toIntOrNull()
        if (input == null || input !in 0..notes.size) {
            println("Неверный ввод, попробуйте снова.")
            listNotes(scanner)
        } else if (input == 0) {
            return
        } else {
            openNote(input - 1)
        }
    }

    private fun openNote(index: Int) {
        val note = notes[index]
        println("Заголовок: ${note.title}")
        println("Содержание: ${note.content}")
    }
}
