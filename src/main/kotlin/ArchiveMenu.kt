import java.util.Scanner

class ArchiveMenu {

    private val archives = mutableListOf<Archive>()
    private val scanner = Scanner(System.`in`)

    fun start() {

        var exit = false

        while (!exit) {

            val menu = Menu("Список архивов:")

            menu.addItem("Создать архив") {
                createArchive()
            }

            archives.forEach { archive ->
                menu.addItem(archive.name) {
                    NotesMenu(archive).start()
                }
            }

            menu.addItem("Выход") {
                exit = true
            }

            menu.show()
        }
    }

    private fun createArchive() {

        println("Введите имя архива:")
        val name = scanner.nextLine()

        if (name.isBlank()) {
            println("Имя архива не может быть пустым")
            return
        }

        archives.add(Archive(name))
    }
}