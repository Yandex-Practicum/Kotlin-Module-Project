package model

data class Archive(
    var title: String,
    val notes: MutableList<Note> = mutableListOf()
) {

    override fun toString(): String {
        return title
    }

    fun addNote(title: String, body: String) {
        notes.add(Note(title, body))
    }
}