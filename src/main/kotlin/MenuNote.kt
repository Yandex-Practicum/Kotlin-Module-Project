import java.util.Scanner
import java.util.Stack

class MenuNote(private val archive: Archive) : StartMenu() {
    override fun displayOptions() {
        println("Заметки расположенные в архиве '${archive.name}':")
        println("Ведите цифру 0 для Создания заметки")
        if (archive.notes.isNotEmpty()) {
            for ((index, note) in archive.notes.withIndex()) {
                println("Ведите цифру ${index + 1} для просмотра содержания Заметки ${note.title}")
            }
        }
        println("Ведите цифру ${archive.notes.size + 1} для перехода Назад")
    }

    override fun handleInput() {
        val input = readInput()

        when (input) {
            0 -> createNote()
            in 1..archive.notes.size -> viewNote(archive.notes[input - 1])
            archive.notes.size + 1 -> goBack()
            else -> println("Неверная команда! Попробуйте ввести цифру еще раз.")
        }
    }

    private fun createNote() {
        val title = Input.readString("Введите название заметки")
        if (title.isBlank()) {
            println("Название заметки не может быть пустым!")
            return
        }
        val content = Input.readString("Введите содержание заметки")
        if (content.isBlank()) {
            println("Содержание заметки не может быть пустым!")
            return
        }
        archive.notes.add(Note(title, content))
        println("Заметка '$title' создана.")
    }

    private fun viewNote(note: Note) {
        println("Название: ${note.title}")
        println("Содержание:\n${note.content}")
        println("\nНажмите Enter, чтобы вернуться назад...")
        Scanner(System.`in`).nextLine()
        goBack()
    }

    private fun readInput(): Int {
        return readLine()?.toIntOrNull() ?: -1
    }
}

