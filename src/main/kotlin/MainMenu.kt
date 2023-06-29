import kotlin.system.exitProcess

class MainMenu () {
    private val archives = mutableListOf<Archive>()

    init {
        createMainMenu()
    }

    private fun createMainMenu() {
        while (true) {
            val newMutableList = mutableListOf("Создать архив" to { index:Int -> createArchive() })
            archives.forEach {
                newMutableList.add(it.name to { index:Int -> createArchiveMenu(index-1)  })
            }
            newMutableList.add("Выход" to { index:Int -> println("Завершение работы приложения."); exitProcess(0) })
            val mainMenu = MenuScreen(newMutableList)

            if (mainMenu.show()) break
        }

    }

    private fun createArchiveMenu(index: Int) {
        while (true) {
            val archive = archives[index]
            val newMutableList = mutableListOf("Создать заметку" to { index:Int -> archive.addNote() })
            archive.getNotes().forEach {
                newMutableList.add(it.title to { index:Int -> it.showNote()})
            }
            newMutableList.add("Назад" to { index:Int ->  })
            val archivesMenu = MenuScreen(newMutableList)

            if (archivesMenu.show()) break
        }
    }

    private fun createArchive() {
        println("Введите название архива:")
        val name = readlnOrNull() ?: ""
        archives.add(Archive(name))
        println("Архив \"$name\" успешно создан.")
    }
}