import java.util.*

class NotesApp( val scanner: Scanner = Scanner(System.`in`)) {
    val archives = mutableListOf<Archive>()

    fun start() {
        while (true) {
            println("\nВыбор архива:")
            println("0. Создать архив")
            archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
            println("${archives.size + 1}. Выход")
            print("Введите номер: ")

            when (val input = scanner.nextLine()) {
                "0" -> createArchive()
                "${archives.size + 1}" -> break
                else -> {
                    val index = input.toIntOrNull()?.minus(1)
                    if (index != null && index in archives.indices) {
                        ArchiveScreen(archives[index], scanner).show()
                    } else {
                        println("Неверный ввод, попробуйте снова.")
                    }
                }
            }
        }
    }

    fun createArchive() {
        var name = ""
        while (name.isBlank()) {
            print("Введите название архива: ")
            name = scanner.nextLine()
            if (name.isBlank()) {
                println("Поле пустое, попробуйте еще раз.")
            }
        }
        val newArchive = Archive(name)
        archives.add(newArchive)
        println("Архив '$name' создан.")
    }
}