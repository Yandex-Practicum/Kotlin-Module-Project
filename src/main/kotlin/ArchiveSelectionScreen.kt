class ArchiveSelectionScreen : Screen<Any?>() {
    override fun show() {
        if (archives.isEmpty()) {
            println("Нет архивов.")
        } else {
            for ((index, archive) in archives.keys.withIndex()) {
                println("${index + 1}. $archive")
            }
            println("${archives.size + 1}. Назад")
            print("Выберите архив: ")
            val choice = scanner.nextLine().toIntOrNull()
            if (choice == null || choice < 1 || choice > archives.size) {
                println("Неверный выбор. Пожалуйста, попробуйте снова.")
                return
            } else if (choice == archives.size + 1) {
                MainMenu().show()
            }
            currentArchive = archives.keys.elementAt(choice - 1)
            NoteMenu().show()
        }
    }
}