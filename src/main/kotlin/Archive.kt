data class Archive(val name: String, val notes: MutableList<Note> = mutableListOf())

data class Note(val name: String, val content: String)