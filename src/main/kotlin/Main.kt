fun main(args: Array<String>) {
    val archiveList = mutableListOf<Archive>()

    fun displayArchivesMenu() {
        var isProgramRunning = true
        while (isProgramRunning) {
            val mainMenu = Menu("=== Управление архивами: ===")
            mainMenu.addItem("Создать новый архив") {
                println("Введите название нового архива::")
                val archiveName = promptForNonEmptyInput("Ошибка: название архива обязательно!")
                archiveList.add(Archive(archiveName))
                println("Архив '$archiveName' успешно создан")
            }

            archiveList.forEach { currentArchive ->
                mainMenu.addItem(currentArchive.archiveName) {
                    val archiveSubMenu = Menu("=== Архив: ${currentArchive.archiveName} ===")
                    archiveSubMenu.addItem("Создать заметку") {
                        currentArchive.addNote()
                    }
                    archiveSubMenu.addItem("Показать все заметки") {
                        currentArchive.showNotes()
                    }
                    archiveSubMenu.addItem("Назад") {}
                    archiveSubMenu.display()
                }
            }
            mainMenu.addItem("Выйти из программы") {
                println("До новых встреч! Программа завершена!")
                isProgramRunning = false
            }
            mainMenu.display()
        }
    }
    displayArchivesMenu()
}

fun promptForNonEmptyInput(errorMsg: String): String {
    while (true) {
        val line = readln()
        if (line.isNotBlank()) return line
        println(errorMsg)
    }
}