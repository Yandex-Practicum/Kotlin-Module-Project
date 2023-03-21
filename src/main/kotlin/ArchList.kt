class ArchList() : Commander() {
    private fun addArch(): String {
        println("Введите имя нового архива:")
        return readLine()!!
    }

    override fun printing() {
        val noteMenu = NoteList()
        while (true) {
            println("Список архивов")
            println("0. Создать архив")
            menuNumb = menu.size + 1
            if (menu.isNotEmpty()) command()
            println("${menuNumb}. Выход.")
            choice = commandReader()
            when (choice) {
                0 -> {
                    menu[menuNumb] = addArch()
                }
                menuNumb -> return
                else -> if (menu.contains(choice)) noteMenu.printing() else println("Архива с выбранным номером не существует")
            }
        }
    }
}