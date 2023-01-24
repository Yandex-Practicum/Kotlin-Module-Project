package data

data class Archive(override val title: String, val notes: MutableList<Note>) : Entity(title)