class Archive(var archName: String, var notes: MutableList<Note> = mutableListOf()) : Title(archName) {
    fun addNote(note: Note) {
        notes.add(note)
    }

    fun getAllNotes(): MutableList<Note> {
        return notes
    }


}