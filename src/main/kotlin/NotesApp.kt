class NotesApp {
    private val archives = mutableListOf<Archive>()

    fun start() {
        while (true) {
            println("Список архивов:")
            println("0. Создать архив")
            for ((index, archive) in archives.withIndex()) {
                println("${index + 1}. ${archive.name}")
            }
            println("${archives.size + 1}. Выход")

            val choice = readUserInput()
            when (choice) {
                0 -> createArchive()
                in 1..archives.size -> archives[choice - 1].showMenu()
                archives.size + 1 -> break
                else -> println("Неверный ввод. Попробуйте снова.")
            }
        }
    }

    private fun createArchive() {
        println("Введите имя архива:")
        val name = readLine()?.trim()
        if (name.isNullOrEmpty()) {
            println("Имя архива не может быть пустым.")
            return
        }
        archives.add(Archive(name))
        println("Архив '$name' создан.")
    }

    fun readUserInput(): Int {
        while (true) {
            val input = readLine()
            if (input != null && input.toIntOrNull() != null) {
                return input.toInt()
            }
            println("Введите число.")
        }
    }
}
