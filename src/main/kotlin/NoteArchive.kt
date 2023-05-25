class NoteArchive(
    val name: String,
    val noteArchive: MutableMap<Int, Note> = mutableMapOf()
) {
    fun addToNoteArchive (str: String) {
        noteArchive[(noteArchive.size + 1)] = Note(str)
    }

}