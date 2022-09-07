data class Archive(private val title: String) {
    private val noteList = mutableListOf<Note>()
    override fun toString(): String {
        return title
    }

    public fun addNote() {
        println("Введите заголовок заметки")
        val title = scanner.nextLine()
        println("Введите текст заметки")
        val text = scanner.nextLine()

        noteList.add(Note(title, text))
    }

    public fun returnNoteList(): MutableList<Note> {
        return noteList
    }

    public fun printNoteList() {
        noteList.forEachIndexed { i, note -> println("${i + 1} $note") }
    }
}