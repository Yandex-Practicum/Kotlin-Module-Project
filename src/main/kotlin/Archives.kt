import java.util.Scanner

class Archives {

    val archives = mutableListOf<Archive>()

    fun archivesMenu() {
        println("Выбор архива")
        while (true) {
            if (archives.isEmpty()) {
                println("Архивов пока нет")
            }

            println("Введите команду: \n 0. Выход \n 1. Создать архив")
            archives.forEachIndexed { index, archive ->
                println(" ${index + 2}. ${archive.name}") }

            val command = Utils.commandChecker() ?: continue
            when {
                 command == 1 ->{
                    println("Создание архива")
                    println("Введите название архива")
                    val archiveName = Scanner(System.`in`).nextLine()

                    addArchive(Archive(archiveName))
                }

                command == 0 -> {
                    println("Выход")
                    return
                }

                command in 2..archives.size + 1 -> {
                    val selectedArchive = archives[command - 2]
                    selectedArchive.archiveMenu()

                }
                else -> println("Ошибка: выберите команду из списка")
            }
        }
    }

    fun addArchive(archive: Archive) {
        archives.add(archive)
    }
}

