
fun main() {
    val menu = Menu()
    val archives = mutableListOf<Archive>()

    while (true) {
        val archiveItems = mutableListOf("Создать архив", "Выход")
        archives.forEachIndexed { index, archive ->
            archiveItems.add(index + 1, archive.name)
        }

        when (val choice = menu.showMenu(archiveItems, "Список архивов:")) {
            0 -> {
                print("Введите имя архива: ")
                val name = readlnOrNull()
                if (name.isNullOrEmpty()) {
                    println("Имя архива не может быть пустым.")
                } else {
                    archives.add(Archive(name))
                    println("Архив '$name' создан.")
                }
            }
            archiveItems.size - 1 -> {
                println("Выход из программы.")
                return
            }
            else -> {
                val archive = archives[choice - 1]
                handleArchive(archive, menu)
            }
        }
    }
}
