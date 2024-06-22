class Archive(val name:String) {
    override fun toString(): String {
        return name
    }

    val noteList: MutableList<Note> = mutableListOf()
    fun addNote(note: Note) {
        noteList.add(noteList.size,note)
    }


}