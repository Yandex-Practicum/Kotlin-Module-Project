data class Archive(private val title: String) {
    private val noteList = mutableListOf<Note>()
    override fun toString(): String {
        return title
    }

    fun addNote() {
        println("Введите заголовок заметки")
        val title = scanner.nextLine()
        println("Введите текст заметки")
        val text = scanner.nextLine()

        noteList.add(Note(title, text))
    }

    fun returnNoteList(): List<Note> {
        return noteList
    }
}