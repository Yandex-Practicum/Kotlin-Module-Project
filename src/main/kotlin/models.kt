class Archive(val name: String, val notes: MutableList<Note> = mutableListOf())

class Note(val title: String, val content: String)