import java.util.Scanner

class ArchiveMenu(scanner: Scanner) : Menu(scanner) {
    init {
        items.add(Item(0, "Вернуться назад", ::goBack)) // Добавляем пункт "Вернуться назад"
        items.add(Item(1, "Создать архив", ::createArchive))
        items.add(Item(2, "Просмотр архива", ::viewArchives))
        items.add(Item(3, "Создать заметку", ::createNote))

    }

    private fun createArchive(archives: HashMap<String, HashMap<String, String>>) {
        print("Введите название архива: ")
        val archiveName = scanner.nextLine().trim()
        if (archiveName.isNotEmpty()) {
            if (!archives.containsKey(archiveName)) {
                archives[archiveName] = HashMap()
                println("Архив '$archiveName' создан.")
            } else {
                println("Архив с таким именем уже существует.")
                goBack(archives)
            }
        } else {
            println("Имя архива не может быть пустым.")
            goBack(archives)
        }
        goBack(archives) // Добавляем возврат в главное меню после создания архива
    }

    private fun viewArchives(archives: HashMap<String, HashMap<String, String>>) {
        println("Список архивов:")
        archives.keys.forEachIndexed { index, key -> println("${index + 1}. $key") }
        println("0. Вернуться назад")
        print("Ваш выбор: ")
        val choice = scanner.nextLine()

        try {
            val selectedIndex = choice.toInt() - 1 // Корректируем индекс, так как выбор начинается с 1
            if (selectedIndex in 0 until archives.size) {
                val selectedArchive = archives.keys.toList()[selectedIndex]
                println("Вы выбрали архив $selectedArchive.")
                viewNotesInArchive(selectedArchive, archives) // Вызываем метод для просмотра заметок
            } else if (choice == "0") {
                goBack(archives)
            } else {
                println("Некорректный выбор. Попробуйте снова.")
            }
        } catch (e: NumberFormatException) {
            println("Пожалуйста, введите целое число.")
            goBack(archives)
        }
    }

    private fun viewNotesInArchive(archiveName: String, archives: HashMap<String, HashMap<String, String>>) {
        if (archives.containsKey(archiveName)) {
            val notes = archives[archiveName]!!
            println("Список заметок в архиве $archiveName:")
            notes.forEach { (title, content) -> println("Заголовок: $title, Содержание: $content") }
            goBack(archives) // Добавляем возврат в главное меню после просмотра заметок
        } else {
            println("Архив с таким именем не найден.")
        }
    }

    private fun createNote(archives: HashMap<String, HashMap<String, String>>) {
        print("Введите название архива: ")
        val archiveName = scanner.nextLine().trim()
        if (archiveName.isNotEmpty() && archives.containsKey(archiveName)) {
            print("Введите заголовок заметки: ")
            val noteTitle = scanner.nextLine().trim()
            print("Введите текст заметки: ")
            val noteContent = scanner.nextLine().trim()

            if (noteTitle.isNotEmpty() && noteContent.isNotEmpty()) {
                archives[archiveName]!![noteTitle] = noteContent
                println("Заметка '$noteTitle' создана.")
            } else {
                println("Заголовок или текст заметки не могут быть пустыми.")
            }
        } else {
            println("Архив с таким именем не найден или название архива пустое.")
        }
        goBack(archives) // Добавляем возврат в главное меню после создания заметки
    }


}
