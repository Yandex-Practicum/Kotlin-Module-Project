
import menu.NoteMenu
import java.util.Scanner

class ArchiveMenu {

    private val archives = mutableListOf<Archive>()
    private val scanner = Scanner(System.`in`)

    fun start() {
        val menu = Menu("Список архивов")

        menu.addItem("Создать архив") { createArchive() }
        menu.addItem("Открыть архив") { openArchive() }
        menu.addItem("Выход") {
            println("Выход из программы")
            System.exit(0)
        }

        menu.show()
    }

    private fun createArchive() {
        println("Введите имя архива:")
        val name = scanner.nextLine()

        if (name.isBlank()) {
            println("Имя не может быть пустым")
            return
        }

        archives.add(Archive(name))
        println("Архив создан")
    }

    private fun openArchive() {
        if (archives.isEmpty()) {
            println("Архивов нет")
            return
        }

        archives.forEachIndexed { index, archive ->
            println("$index. ${archive.name}")
        }

        println("Введите номер архива:")
        val index = scanner.nextLine().toIntOrNull()

        if (index == null || index !in archives.indices) {
            println("Неверный номер")
            return
        }

        NoteMenu(archives[index]).start()
    }
}