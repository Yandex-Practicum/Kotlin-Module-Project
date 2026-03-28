package note

import archive.Archive
import menu.Menu
import java.util.Scanner

fun showNotesMenu(archive: Archive) {
    val scanner = Scanner(System.`in`)
    var exit = false

    while (!exit) {
        val menu = Menu("Заметки архива \"${archive.name}\"")

        menu.addItem("Создать заметку") {
            print("Введите название заметки: ")
            val name = scanner.nextLine().trim()
            if (name.isEmpty()) {
                println("Ошибка: имя заметки не может быть пустым.")
                return@addItem
            }

            print("Введите текст заметки: ")
            val content = scanner.nextLine().trim()
            if (content.isEmpty()) {
                println("Ошибка: текст заметки не может быть пустым.")
                return@addItem
            }

            archive.notes.add(Note(name, content))
            println("Заметка \"$name\" создана.")
        }

        archive.notes.forEach { note ->
            menu.addItem(note.name) {
                println("\n=== ${note.name} ===")
                println(note.content)
            }
        }

        menu.addItem("Назад") {
            exit = true
        }

        menu.show()
    }
}
