class ArchiveMenu(
    private val archives: MutableList<Archive>
) {

    fun show() {
        while (true) {
            val items = mutableListOf("Создать архив")

            archives.forEach { archive ->
                items.add(archive.name)
            }

            items.add("Выход")

            val menu = Menu(
                title = "Список архивов:",
                items = items
            )

            when (val choice = menu.show()) {
                0 -> createArchive()

                items.lastIndex -> {
                    println("Программа завершена.")
                    return
                }

                else -> {
                    val archive = archives[choice - 1]
                    NoteMenu(archive).show()
                }
            }
        }
    }

    private fun createArchive() {
        println()
        print("Введите название архива: ")

        val name = readln().trim()

        if (name.isEmpty()) {
            println("Название архива не может быть пустым.")
            return
        }

        archives.add(Archive(name))
        println("Архив «$name» создан.")
    }
}