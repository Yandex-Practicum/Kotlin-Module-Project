import java.util.Scanner

fun main(args: Array<String>) {
    val app: App = App()
    app.start()
}

class App {
    private val menu: Menu = Menu("Список архивов:")
    private val listOfArchives: MutableList<Archive> = mutableListOf()

    init {
        menu.listOfCommands.add(("Создать архив" to {createArchive()}))
    }


    fun start() {
        listOfArchives.forEach { menu.listOfCommands.add(it.name to {it.archiveScreenStart()}) }
        menu.start()
    }

    private fun createArchive() {
        while (true) {
            println("Введите название архива:")
            val name: String = Scanner(System.`in`).nextLine()
            if (name.isEmpty()) {
                println("Название архива не может быть пустым")
            } else {
                val archive = Archive(name)
                listOfArchives.add(archive)
                menu.listOfCommands.add(name to {archive.archiveScreenStart()})
                println("Архив $name был добавлен в список архивов \n")
                break
            }
        }
    }
}
