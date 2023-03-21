class NoteList() : Commander() {
    private fun addNote(): String {
        println("Введите имя новой заметки:")
        return readLine()!!
    }

    private fun writeNote() {
        println("Введите текст заметки")
        noteText[menu.size] = readLine()!!
        println("Заметка сохранена")
    }

    override fun printing() {
        while (true) {
            println("Список заметок")
            println("0. Создать заметку")
            menuNumb = menu.size + 1
            if (menu.isNotEmpty()) command()
            println("${menuNumb}. Выход в меню архивов.")
            choice = commandReader()
            when (choice) {
                0 -> {
                    menu[menuNumb] = addNote()
                    println("Новая заметка создана!")
                    writeNote()
                }
                menuNumb -> return
                else -> if (menu.contains(choice)) {
                    println("Текст заметки:")
                    println(noteText[choice])

                } else println("Заметки с выбранным номером не существует")
            }
        }
    }
}