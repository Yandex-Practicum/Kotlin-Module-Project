class NotesApp {
    private val archives = mutableListOf<Archive>()

    fun run() {
        while (true) {
            printMainOptions()
            val choice = readIntInput()

            when (choice) {
                1 -> createArchive()
                2 -> viewArchives()
                3 -> exitApp()
                else -> println("Некорректный выбор. Попробуйте еще раз.")
            }
        }
    }

    private fun printMainOptions() {
        println("Главное меню:")
        println("1. Создать архив")
        println("2. Просмотр архивов")
        println("3. Выход")
        print("Выберите опцию: ")
    }

    private fun createArchive() {
        print("Введите имя архива: ")
        val archiveName = readLine() ?: ""
        if (archiveName.isNotEmpty()) {
            val archive = Archive(archiveName, mutableListOf())
            archives.add(archive)
            println("Архив '$archiveName' создан.")
        } else {
            println("Имя архива не может быть пустым.")
        }
    }

    private fun viewArchives() {
        while (true) {
            printArchives()
            val choice = readIntInput()

            if (choice in 1..archives.size) {
                val archive = archives[choice - 1]
                viewArchive(archive)
            } else if (choice == archives.size + 1) {
                return
            } else {
                println("Некорректный выбор. Попробуйте еще раз.")
            }
        }
    }

    private fun printArchives() {
        println("Список архивов:")
        for (i in 0 until archives.size) {
            println("${i + 1}. ${archives[i].name}")
        }
        println("${archives.size + 1}. Выход")
        print("Выберите архив или введите ${archives.size + 1} для выхода: ")
    }

    private fun viewArchive(archive: Archive) {
        while (true) {
            printArchiveOptions(archive)
            val choice = readIntInput()

            when (choice) {
                1 -> createNote(archive)
                2 -> viewNotes(archive)
                3 -> return
                else -> println("Некорректный выбор. Попробуйте еще раз.")
            }
        }
    }

    private fun printArchiveOptions(archive: Archive) {
        println("Архив '${archive.name}':")
        println("1. Создать заметку")
        println("2. Просмотр заметок")
        println("3. Назад")
        print("Выберите опцию: ")
    }

    private fun createNote(archive: Archive) {
        print("Введите имя заметки: ")
        val noteName = readLine() ?: ""
        if (noteName.isNotEmpty()) {
            print("Введите текст заметки: ")
            val noteContent = readLine() ?: ""
            if (noteContent.isNotEmpty()) {
                val note = Note(noteName, noteContent)
                archive.notes.add(note)
                println("Заметка '$noteName' создана.")
            } else {
                println("Содержание заметки не может быть пустым.")
            }
        } else {
            println("Имя заметки не может быть пустым.")
        }
    }

    private fun viewNotes(archive: Archive) {
        println("Заметки в архиве '${archive.name}':")
        for (i in 0 until archive.notes.size) {
            println("${i + 1}. ${archive.notes[i].name}")
        }

        print("Выберите номер заметки для просмотра или введите ${archive.notes.size + 1} для выхода: ")
        val choice = readIntInput()

        if (choice in 1..archive.notes.size) {
            val note = archive.notes[choice - 1]
            println("Заметка '${note.name}':")
            println(note.content)
            println("Нажмите Enter, чтобы вернуться.")
            readLine()
        } else if (choice == archive.notes.size + 1) {
            return
        } else {
            println("Некорректный выбор. Попробуйте еще раз.")
        }
    }

    private fun exitApp() {
        println("Выход из приложения.")
        System.exit(0)
    }

    private fun readIntInput(): Int {
        val input = readLine()
        return try {
            input?.toInt() ?: 0
        } catch (e: NumberFormatException) {
            0
        }
    }
}