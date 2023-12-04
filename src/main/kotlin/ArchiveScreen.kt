import java.util.*

class ArchiveScreen(val archive: Archive, val scanner: Scanner) {

    fun show() {
        while (true) {
            println("\nАрхив '${archive.name}':")
            println("0. Создать заметку")
            archive.notes.forEachIndexed { i, note -> println("${i + 1}. ${note.title}") }
            println("${archive.notes.size + 1}. Выйти в главное меню")
            print("Введите номер: ")

            when (val input = scanner.nextLine()) {
                "0" -> createNote()
                "${archive.notes.size + 1}" -> return
                else -> {
                    val noteIndex = input.toIntOrNull()?.minus(1)
                    if (noteIndex != null && noteIndex in archive.notes.indices) {
                        NoteScreen(archive.notes[noteIndex], scanner).show()
                    } else {
                        println("Неверный ввод, попробуйте снова.")
                    }
                }
            }
        }
    }

    fun createNote() {
        var title = ""
        while (title.isBlank()) {
            print("Введите название заметки: ")
            title = scanner.nextLine()
            if (title.isBlank()) {
                println("Поле пустое, попробуйте еще раз.")
            }
        }

        var content = ""
        while (content.isBlank()) {
            print("Введите содержание заметки: ")
            content = scanner.nextLine()
            if (content.isBlank()) {
                println("Поле пустое, попробуйте еще раз.")
            }
        }

        val newNote = Note(title, content)
        archive.notes.add(newNote)
        println("Заметка '$title' добавлена в архив '${archive.name}'.")
    }
}