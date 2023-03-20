class MainMenu : Screen<Any?>() {
    override fun show() {
        while (true) {
            println("Меню:\n1. Список архивов\n2. Создать архив\n3. Выйти\n")
            print("Выберите пункт меню: ")
            val choice = scanner.nextLine().toIntOrNull()
            when (choice) {
                1 -> ArchiveSelectionScreen().show()
                2 -> ArchiveCreationScreen().show()
                3 -> return
                else -> println("Неверный выбор. Пожалуйста, попробуйте снова.")
            }
        }
    }
}