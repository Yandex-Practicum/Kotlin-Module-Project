class CreateArchiveMenu(stack: MutableList<Menu>, private val manager: ArchiveManager, helper: MenuScanner) : Menu(stack, helper) {

    override fun showMenu() {
        while (true) {
            println("Создание архива:")
            val options = mutableListOf("Создать архив")
            options.addAll(manager.getArchives().map { it.name })
            options.add("Выйти из программы") // Выйти из программы доступно только в главном меню
            helper.printMenu(options)

            when (val choice = helper.getUserInput()) {
                1 -> createArchive()
                in 2..(manager.getArchives().size + 1) -> openArchive(choice - 2)
                manager.getArchives().size + 2 -> {
                    println("Выход из программы...")
                    System.exit(0) // Завершение программы
                }
                else -> println("Неправильный выбор. Попробуйте снова.")
            }
        }
    }

    private fun createArchive() {
        println("Введите название архива:")
        val name = helper.scanner.nextLine()
        if (name.isNotBlank()) {
            manager.addArchive(name)
            println("Архив '$name' создан.")
        } else {
            println("Архив не может быть без названия.")
        }
    }

    private fun openArchive(index: Int) {
        val archive = manager.getArchive(index)
        if (archive != null) {
            stack.add(this)
            ArchiveMenu(stack, archive, helper).showMenu()
        } else {
            println("Архив не найден.")
        }
    }
}

class ArchiveMenu(stack: MutableList<Menu>, private val archive: Archive, helper: MenuScanner) : Menu(stack, helper) {

    override fun showMenu() {
        while (true) {
            println("Меню архива: ${archive.name}")
            val options = mutableListOf("Создать заметку")
            options.addAll(archive.notes.map { it.title })
            options.add("Вернуться назад")
            helper.printMenu(options)

            when (val choice = helper.getUserInput()) {
                1 -> createNote()
                in 2..(archive.notes.size + 1) -> openNote(choice - 2)
                archive.notes.size + 2 -> {
                    goBack()
                    return
                }
                else -> println("Вы ввели некорректный символ. Введите доступные числа.")
            }
        }
    }

    private fun createNote() {
        println("Введите название заметки:")
        val title = helper.scanner.nextLine()
        if (title.isNotBlank()) {
            println("Введите текст заметки:")
            val content = helper.scanner.nextLine()
            if (content.isNotBlank()) {
                archive.notes.add(Note(title, content))
                println("Заметка '$title' создана.")
            } else {
                println("Содержание заметки не может быть пустым.")
            }
        } else {
            println("Название заметки не может быть пустым.")
        }
    }

    private fun openNote(index: Int) {
        val note = archive.notes.getOrNull(index)
        if (note != null) {
            stack.add(this)
            ViewNoteMenu(stack, note, helper).showMenu()
        } else {
            println("Заметка не найдена.")
        }
    }
}