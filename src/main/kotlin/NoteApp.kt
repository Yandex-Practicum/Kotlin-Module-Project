import java.util.Scanner

class NoteTakingApp(private val scanner: Scanner = Scanner(System.`in`)) {
    private val archives = mutableListOf<Archive>()

    fun start() {
        while (true) {
            println("Меню приложения:")
            println("1. Создать архив")
            println("2. Просмотреть архивы")
            println("3. Выход")
            when (readInt("Выберите действие: ")) {
                1 -> createArchive()
                2 -> showArchives()
                3 -> {
                    println("Выход из программы.")
                    return
                }
                else -> println("Некорректный ввод, попробуйте снова.")
            }
        }
    }

    private fun createArchive() {
        val archiveName = readNonEmptyString("Введите имя архива: ")
        archives.add(Archive(archiveName))
        println("Архив '$archiveName' успешно создан.")
    }

    private fun showArchives() {
        if (archives.isEmpty()) {
            println("Нет доступных архивов.")
        } else {
            archives.forEachIndexed { index, archive ->
                println("${index + 1}. ${archive.name}")
            }
            selectArchive()
        }
    }

    private fun selectArchive() {
        val index = readInt("Выберите архив для работы (или 0 для назад): ") - 1
        when {
            index in archives.indices -> {
                val archive = archives[index]
                archiveMenu(archive)
            }
            index == -1 -> return
            else -> println("Некорректный ввод.")
        }
    }

    private fun archiveMenu(archive: Archive) {
        while (true) {
            println("Меню архива \"${archive.name}\":")
            println("1. Добавить заметку")
            println("2. Просмотреть заметки")
            println("3. Назад")

            when (readInt("Выберите опцию: ")) {
                1 -> archive.createNote(scanner)
                2 -> archive.displayNotes()
                3 -> return
                else -> println("Некорректный ввод, попробуйте снова.")
            }
        }
    }

    private fun readInt(prompt: String): Int {
        print(prompt)
        while (!scanner.hasNextInt()) {
            println("Пожалуйста, введите числовое значение.")
            scanner.next()
        }
        return scanner.nextInt().also { scanner.nextLine() }
    }

    private fun readNonEmptyString(prompt: String): String {
        println(prompt)
        val input = readlnOrNull() ?: ""
        if (input.isEmpty()) {
            println("Ошибка: Ввод не может быть пустым.")
            return readNonEmptyString(prompt)
        }
        return input
    }
}