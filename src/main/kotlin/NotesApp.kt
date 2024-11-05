class NotesApp {
    private val archives: MutableList<Archive> = mutableListOf()

    fun run() {
        mainMenu()
    }

    private fun mainMenu() {
        while (true) {
            val options = listOf("Выбор архива", "Создание архива")
            val choice = displayMenu("Главное меню", options)

            when (choice) {
                1 -> selectArchive()
                2 -> createArchive()
                0 -> return
            }
        }
    }

    private fun selectArchive() {
        if (archives.isEmpty()) {
            println("Архивов пока нет")
            return
        }

        while (true) {
            val options = archives.map { it.name }
            val choice = displayMenu("Выбор архива", options)

            when (choice) {
                in 1..archives.size -> selectNote(archives[choice - 1])
                0 -> return
            }
        }
    }

    private fun createArchive() {
        while (true) {
            println("Введите название архива (или 'назад' для выхода):")
            val name = readLine()!!.trim()

            if (name.equals("назад", ignoreCase = true)) {
                return
            }

            if (name.isNotEmpty()) {
                archives.add(Archive(name))
                println("Архив '$name' создан.")
                return
            } else {
                println("Название не может быть пустым. Попробуйте еще раз.")
            }
        }
    }

    private fun selectNote(archive: Archive) {
        while (true) {
            val options = archive.notes.map { it.title } + "Создать заметку"
            val choice = displayMenu("Выбор заметки в архиве: ${archive.name}", options)

            when (choice) {
                in 1..archive.notes.size -> showNote(archive.notes[choice - 1])
                archive.notes.size + 1 -> createNote(archive)
                0 -> return
            }
        }
    }

    private fun createNote(archive: Archive) {
        while (true) {
            println("Введите заголовок заметки (или 'назад' для выхода):")
            val title = readLine()!!.trim()

            if (title.equals("назад", ignoreCase = true)) {
                return
            }

            if (title.isEmpty()) {
                println("Заголовок заметки не может быть пустым. Попробуйте еще раз.")
                continue
            }

            println("Введите текст заметки (или 'назад' для выхода):")
            val content = readLine()!!.trim()

            if (content.equals("назад", ignoreCase = true)) {
                return
            }

            if (content.isNotEmpty()) {
                archive.notes.add(Note(title, content))
                println("Заметка '$title' создана.")
                return
            } else {
                println("Содержимое не может быть пустым! Попробуйте еще раз.")
            }
        }
    }

    private fun showNote(note: Note) {
        println("Заголовок: ${note.title}")
        println("Содержимое: ${note.content}")

    }

    private fun displayMenu(title: String, options: List<String>): Int {
        println("\n$title")
        options.forEachIndexed { index, option -> println("${index + 1}. $option") }
        println("0. Выход")

        while (true) {
            val input = readLine()
            try {
                val choice = input!!.toInt()
                if (choice in 0..options.size) {
                    return choice
                } else {
                    println("Такого пункта нет. Попробуйте еще раз.")
                }
            } catch (e: NumberFormatException) {
                println("Введите цифру. Попробуйте еще раз.")
            }
        }
    }
}