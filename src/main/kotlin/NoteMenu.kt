class NoteMenu : Screen<Any?>() {
    override fun show() {
        while (true) {
            println("Меню заметок:\n0. Удалить архив\n1. Список заметок\n2. Создать заметку\n3. Назад")
            print("Выберите пункт меню: ")
            val choice = scanner.nextLine().toIntOrNull()
            when (choice) {
                0 -> deleteArchive()
                1 -> NoteSelectionScreen().show()
                2 -> NoteCreationScreen().show()
                3 -> return
                else -> println("Неверный выбор. Пожалуйста, попробуйте снова.")
            }
        }
    }

    private fun deleteArchive() {
        if (currentArchive == null) {
            println("Нет выбранного архива для удаления.")
            return
        }

        print("Вы уверены, что хотите удалить архив '$currentArchive'? (введите \"да\" или любой другой символ для отмены): ")
        val confirm = scanner.nextLine()
        if (confirm.lowercase().trim() == "да") {
            archives.remove(currentArchive)
            currentArchive = null
            println("Архив успешно удален.")
            MainMenu().show()
        } else {
            println("Удаление архива отменено.")
        }
    }
}