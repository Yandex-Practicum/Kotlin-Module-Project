package data

data class Note(override val title: String, val text: String) : Entity(title)
