class NoteEditScreen(private val note: String) : Screen<Any?>() {
    override fun show() {
        print("Введите новый текст заметки: ")
        val newText = scanner.nextLine()

        archives[currentArchive]?.set(note, newText)
    }
}