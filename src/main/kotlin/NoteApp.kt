import java.util.Scanner

class NoteApp {
    private val archives = mutableListOf<Archive>()
    private val scanner = Scanner(System.`in`)

    fun start() {
        while (true) {
            println("Выберите действие:")
            println("0. Выйти")
            println("1. Создать архив")
            println("2. Просмотреть архивы")
            when (readUserInput()) {
                "0" -> return
                "1" -> createArchive()
                "2" -> viewArchives()
                else -> println("Неверный ввод, попробуйте снова.")
            }
        }
    }

    private fun createArchive() {
        println("Введите имя архива (или введите '0' для отмены):")
        val name = scanner.nextLine().trim()
        if (name == "0") {
            return
        }
        if (name.isEmpty()) {
            println("Имя архива не может быть пустым.")
            return
        }
        archives.add(Archive(name))
        println("Архив '$name' создан.")
    }

    private fun viewArchives() {
        if (archives.isEmpty()) {
            println("Нет доступных архивов.")
            return
        }
        println("Выберите архив:")
        println("0. Вернуться")
        for ((index, archive) in archives.withIndex()) {
            println("${index + 1}. ${archive.name}")
        }
        val archiveIndex = readUserInput().toIntOrNull()
        if (archiveIndex == null || archiveIndex !in 0..archives.size) {
            println("Неверный ввод, попробуйте снова.")
            return
        }
        if (archiveIndex == 0) {
            return
        }
        archives[archiveIndex - 1].viewNotes(scanner)
    }

    private fun readUserInput(): String {
        return scanner.nextLine().trim()
    }
}
