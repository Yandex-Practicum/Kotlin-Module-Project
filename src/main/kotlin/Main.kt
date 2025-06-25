//fun main(args: Array<String>) {
  //  println("Hello World!")
//}

package app

fun main() {
    val archives = mutableListOf<Archive>()

    fun showArchives() {
        var running = true
        while (running) {
            val archiveMenu = Menu("Список архивов:")
            archiveMenu.addItem("Создать архив") {
                println("Введите название архива:")
                val name = readNonEmptyLine("Название архива не может быть пустым.")
                archives.add(Archive(name))
                println("Архив добавлен.")
            }

            archives.forEach { archive ->
                archiveMenu.addItem(archive.name) {
                    val subMenu = Menu("Архив: ${archive.name}")
                    subMenu.addItem("Добавить заметку") { archive.addNote() }
                    subMenu.addItem("Просмотреть заметки") { archive.showNotes() }
                    subMenu.addItem("Назад") {}
                    subMenu.show()
                }
            }

            archiveMenu.addItem("Выход из программы") {
                println("До свидания!")
                running = false // ✅ Меняем флаг, чтобы выйти из while
            }

            archiveMenu.show()
        }
    }

    showArchives()
}

fun readNonEmptyLine(errorMsg: String): String {
    while (true) {
        val line = readln()
        if (line.isNotBlank()) return line
        println(errorMsg)
    }
}