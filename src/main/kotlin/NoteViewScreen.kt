class NoteViewScreen(private val note: String) : Screen<Any?>() {
    override fun show() {
        println(note)
        println(archives[currentArchive]?.get(note) ?: "Текст заметки отсутствует")

        while (true) {
            println("1. Редактировать")
            println("2. Удалить")
            println("3. Назад")
            print("Выберите пункт меню: ")
            val choice = scanner.nextLine().toIntOrNull()
            when (choice) {
                1 -> NoteEditScreen(note).show()
                2 -> {
                    archives[currentArchive]?.remove(note)
                    return
                }
                3 -> return
                else -> println("Неверный выбор. Пожалуйста, попробуйте снова.")
            }
        }
    }
}