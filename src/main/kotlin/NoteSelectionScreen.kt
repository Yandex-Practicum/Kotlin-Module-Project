class NoteSelectionScreen : Screen<Any?>() {
    override fun show() {
        val notes = archives[currentArchive] ?: return
        if (notes.isEmpty()) {
            println("Нет заметок.")
        } else {
            for ((index, note) in notes.keys.withIndex()) {
                println("${index + 1}. $note")
            }
            println("${notes.size + 1}. Назад")
            print("Выберите заметку: ")
            val choice = scanner.nextLine().toIntOrNull()
            if (choice == null || choice < 1 || choice > notes.size) {
                println("Неверный выбор. Пожалуйста, попробуйте снова.")
                return
            } else if (choice == notes.size + 1) {
                NoteMenu().show()
            }
            val note = notes.keys.elementAt(choice - 1)
            NoteViewScreen(note).show()
        }
    }
}