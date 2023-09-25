class Archive(val archiveName: String) : Entity {

    data class Note(val noteName: String, val noteText: String) {
        companion object {
            private const val TOP = "ЗАМЕТКА: "
            private const val TEXT = "Текст: "
        }

        fun showNote() {
            println("$TOP\n\t${this.noteName}")
            println("$TEXT\n\t${this.noteText}")
        }
    }

    private val notes = mutableListOf<Note>()

    fun addNote(noteName: String, noteText: String) = notes.add(Note(noteName, noteText))

    fun getNote(noteName: String): Note? = notes.find { noteName == it.noteName }

    fun getListOfNotes() = notes

}