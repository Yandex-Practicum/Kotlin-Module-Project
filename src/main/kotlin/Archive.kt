import java.util.Scanner

class Archive(val name: String) {
    private val notes = mutableListOf<Note>()

    fun createNote(scanner: Scanner) {
        val title = readNonEmptyString(scanner, "Введите заголовок заметки: ")
        val content = readNonEmptyString(scanner, "Введите содержание заметки: ")
        notes.add(Note(title, content))
        println("Заметка \"$title\" добавлена.")
    }

    fun displayNotes() {
        if (notes.isEmpty()) {
            println("Нет заметок в архиве.")
        } else {
            notes.forEach { println("- ${it.title}: ${it.content}") }
        }
    }

    private fun readNonEmptyString(scanner: Scanner, prompt: String): String {
        while (true) {
            print(prompt)
            val input = scanner.nextLine()
            if (input.isNotBlank()) {
                return input
            }
            println("Значение не может быть пустым. Попробуйте снова.")
        }
    }
}