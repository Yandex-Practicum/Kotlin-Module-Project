import java.util.Scanner
import kotlin.system.exitProcess

class Menu(private val title: String) {
    private val options = mutableListOf<Pair<String, () -> Unit>>()

    fun addOption(name: String, action: () -> Unit) {
        options.add(name to action)
    }

    fun show() {
        while (true) {
            println("\n$title")
            options.forEachIndexed { index, (name, _) ->
                println("$index. $name")
            }
            print("Введите номер пункта: ")

            val input = readLine()
            val index = input?.toIntOrNull()
            if (index == null || index !in options.indices) {
                println("Некорректный ввод. Попробуйте снова.")
                continue
            }

            options[index].second.invoke()
            break
        }
    }
}

class Archive(val name: String) {
    private val notes = mutableListOf<Note>()

    fun showNotesMenu() {
        val menu = Menu("Список заметок в архиве '$name'")
        menu.addOption("Создать заметку") { createNote() }
        notes.forEachIndexed { index, note ->
            menu.addOption(note.title) { showNoteContent(note) }
        }
        menu.addOption("Назад") {}
        menu.show()
    }

    private fun createNote() {
        println("Введите название заметки:")
        val title = readLine().orEmpty().trim()
        if (title.isEmpty()) {
            println("Название заметки не может быть пустым.")
            return
        }

        println("Введите содержимое заметки:")
        val content = readLine().orEmpty().trim()
        if (content.isEmpty()) {
            println("Содержимое заметки не может быть пустым.")
            return
        }

        notes.add(Note(title, content))
        println("Заметка '$title' создана.")
    }

    private fun showNoteContent(note: Note) {
        println("\nЗаметка '${note.title}':")
        println(note.content)
        println("\nНажмите Enter, чтобы вернуться в меню.")
        readLine()
    }
}

data class Note(val title: String, val content: String)

val archives = mutableListOf<Archive>()

fun createArchive() {
    println("Введите название архива:")
    val name = readLine().orEmpty().trim()
    if (name.isEmpty()) {
        println("Название архива не может быть пустым.")
        return
    }

    archives.add(Archive(name))
    println("Архив '$name' создан.")
}

fun showArchivesMenu() {
    val menu = Menu("Список архивов")
    menu.addOption("Создать архив") { createArchive() }
    archives.forEachIndexed { index, archive ->
        menu.addOption(archive.name) { archive.showNotesMenu() }
    }
    menu.addOption("Выход") { exitProcess(0) }
    menu.show()
}

fun main() {
    println("Добро пожаловать в приложение 'Заметки'!")
    while (true) {
        showArchivesMenu()
    }
}
