class MenuArchive : StartMenu() {
    private val archives = mutableListOf<Archive>()

    override fun displayOptions() {
        println("Архивы:")
        println("Ведите цифру 0 для выбора Создать архив")
        if (archives.isNotEmpty()) {
            for ((index, archive) in archives.withIndex()) {
                println("Ведите цифру ${index + 1} для перехода в Архив ${archive.name} ")
            }
        }
        println("Введите цифру ${archives.size + 1} для Выхода из программы")
    }

    override fun handleInput() {
        val input = readInput()

        when (input) {
            0 -> createArchive()
            in 1..archives.size -> viewArchive(archives[input - 1])
            archives.size + 1 -> exit()
            else -> println("Неверная команда! Введите цифру еще раз.")
        }
    }

    private fun createArchive() {
        val name = Input.readString("Укажите имя архива")
        if (name.isBlank()) {
            println("Имя архива не может быть пустым!")
            return
        }
        archives.add(Archive(name, mutableListOf()))
        println("Архив '$name' создан.")
    }

    private fun viewArchive(archive: Archive) {
        menuStack.push(this)
        val noteMenu = MenuNote(archive)
        noteMenu.run()
    }

    private fun exit() {
        isRunning = false
        println("Выход из программы...")
    }

    private fun readInput(): Int {
        return readLine()?.toIntOrNull() ?: -1
    }
}
