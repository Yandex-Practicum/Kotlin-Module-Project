class Archive(
    val name: String,
    val notes: MutableList<Note> = mutableListOf()
) {
    fun addNote(note: Note) {
        notes.add(note)
    }
}