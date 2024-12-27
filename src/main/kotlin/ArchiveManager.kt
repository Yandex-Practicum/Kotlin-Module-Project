class ArchiveManager {
    private val archives = mutableListOf<Archive>()

    fun showArchivesMenu() {
        while (true) {
            println("Список архивов:")
            println("0. Создать архив")
            for ((index, archive) in archives.withIndex()) {
                println("${index + 1}. ${archive.name}")
            }
            println("${archives.size + 1}. Выход")
            print("Введите номер пункта: ")

            val input = readLine()
            if (input == null || !input.matches("\\d+".toRegex())) {
                println("Пожалуйста, введите число.")
                continue
            }

            val choice = input.toInt()
            when {
                choice == 0 -> createArchive()
                choice in 1..archives.size -> archives[choice - 1].showNotesMenu()
                choice == archives.size + 1 -> return
                else -> println("Некорректный ввод. Попробуйте снова.")
            }
        }
    }

    fun createArchive() {
        print("Введите название архива: ")
        val name = readLine().orEmpty()
        if (name.isBlank()) {
            println("Название архива не может быть пустым.")
            return
        }
        archives.add(Archive(name))
        println("Архив '$name' создан.")
    }
}
