fun main() {
    val app = NotesApp()
    app.run()
}

class NotesApp {
    private val archives = mutableListOf<Archive>()

    fun run() {
        while (true) {
            println("\nСписок архивов:")
            println("0. Создать архив")
            archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
            println("${archives.size + 1}. Выход")

            when (val choice = readUserInput(archives.size + 1)) {
                0 -> createArchive()
                archives.size + 1 -> return
                else -> archives[choice - 1].open()
            }
        }
    }

    private fun createArchive() {
        print("Введите имя архива: ")
        val name = readNonEmptyInput()
        archives.add(Archive(name))
        println("Архив '$name' создан.")
    }
}

class Archive(val name: String) {
    private val notes = mutableListOf<Note>()

    fun open() {
        while (true) {
            println("\nАрхив: $name")
            println("0. Создать заметку")
            notes.forEachIndexed { index, note -> println("${index + 1}. ${note.title}") }
            println("${notes.size + 1}. Назад")

            when (val choice = readUserInput(notes.size + 1)) {
                0 -> createNote()
                notes.size + 1 -> return
                else -> notes[choice - 1].view()
            }
        }
    }

    private fun createNote() {
        print("Введите заголовок заметки: ")
        val title = readNonEmptyInput()
        print("Введите текст заметки: ")
        val content = readNonEmptyInput()
        notes.add(Note(title, content))
        println("Заметка '$title' создана.")
    }
}

class Note(val title: String, private val content: String) {
    fun view() {
        println("\nЗаметка: $title")
        println(content)
        println("Нажмите Enter для возврата.")
        readLine()
    }
}

fun readUserInput(max: Int): Int {
    while (true) {
        print("Введите номер пункта: ")
        val input = readLine()
        val choice = input?.toIntOrNull()
        if (choice != null && choice in 0..max) return choice
        println("Некорректный ввод. Попробуйте снова.")
    }
}

fun readNonEmptyInput(): String {
    while (true) {
        val input = readLine()?.trim()
        if (!input.isNullOrEmpty()) return input
        println("Поле не может быть пустым. Введите значение.")
    }
}
