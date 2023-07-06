import java.util.Scanner

data class Archive(
    val name: String,
    val archivesList: MutableList<Note>
) {
    override fun toString() = name
}

class ArсhiveOperators(
    private val archives: MutableList<Archive> = mutableListOf()
) {
    fun displayMenu() {
        println("Меню: ")
        println("1. Создать архив")
        println("2. Выберите архив")
        println("3. Выход")
    }

    fun selectedMenu() {
        val scanner = Scanner(System.`in`)
        var choise: Int
        while (true) {
            println("Введите ваш выбор: ")
            if (scanner.hasNextInt()) {
                choise = scanner.nextInt()
                when (choise) {
                    1 -> {
                        createArchive()
                        break
                    }
                    2 -> {
                        chooseArchive()
                        break
                    }
                    3 -> {
                        exitMenu()
                        break
                    }
                    else -> println("Вы ввели некорректное значение. Пожалуйста введите цифру ещё раз")
                }
            } else {
                println("Вы ввели некорректное значение. Пожалуйста введите цифру ещё раз")
                scanner.next()
            }
        }
    }

    fun createArchive() {
        println("Введите название архива или \"-\" что бы вернуться.")
        val archiveName = readln().trim()
        if (archiveName.isEmpty()) {
            println("Вы не можете создать архив без заголовка")
        } else if (archiveName.equals("-")) {
            return
        } else {
            val notes = mutableListOf<Note>()
            archives.add(Archive(archiveName, notes))
            println("Архив создан")
            return
        }
    }

    private fun chooseArchive() {

        println("Доступные архивы: ")
        archives.forEachIndexed { index, item ->
            println("${index + 1}. $item")
        }

        println("0. Вернуться к предыдущему меню")
        print("Введите номер архива: ")
        val scanner = Scanner(System.`in`)
        var choice: Int
        while (true) {
            println("Введите номер архива: ")
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt()
                if (choice in 1..archives.size) {
                   // return archives[choice - 1]
                    val noteOperators = NoteOperations(archives[choice - 1])
                    noteOperators.displayMenuNotes()
                    noteOperators.selectedMenuNote()
                    break
                } else {
                    println("Некорректный номер архива. Пожалуйста, введите номер ещё раз")
                }
            } else {
                println("Вы ввели некорректное значение. Пожалуйста, введите номер архива ещё раз")
                scanner.next()
            }
        }
    }

    private fun exitMenu() {
        println("Выход из программы")
        System.exit(0)
    }
}
