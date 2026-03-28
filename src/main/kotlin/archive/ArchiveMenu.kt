package archive

import menu.Menu
import storage.Storage
import note.showNotesMenu
import java.util.Scanner
import kotlin.system.exitProcess

fun showArchiveMenu() {
    val scanner = Scanner(System.`in`)

    while (true) {
        val menu = Menu("Список архивов:")

        menu.addItem("Создать архив") {
            print("Введите название архива: ")
            val name = scanner.nextLine().trim()

            if (name.isEmpty()) {
                println("Ошибка: имя архива не может быть пустым.")
                return@addItem
            }

            Storage.archives.add(Archive(name))
            println("Архив \"$name\" создан.")
        }

        Storage.archives.forEach { archive ->
            menu.addItem(archive.name) {
                showNotesMenu(archive)
            }
        }

        menu.addItem("Выход из программы") {
            println("Завершение работы.")
            exitProcess(0)
        }

        menu.show()
    }
}
