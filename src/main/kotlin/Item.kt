data class Item(val itemName: String) {
    private val notes = mutableListOf<String>()

    fun addNote(note: String) {
        notes.add(note)
    }

    fun listNotes(): List<String> {
        return notes
    }

    fun addTextToNoteAt(index: Int, text: String) {
        if (index in notes.indices) {
            notes[index] += "\n$text"
        }
    }
}
