class Archive(var name: String, var notes: MutableList<Note> = mutableListOf()) {
    fun addNote(note: Note) {
        notes.add(note)
    }

    fun getAllNotes(): MutableList<Note> {
        return notes
    }


}