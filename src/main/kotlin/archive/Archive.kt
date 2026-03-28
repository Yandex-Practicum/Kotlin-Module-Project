package archive

import note.Note

data class Archive(
    val name: String,
    val notes: MutableList<Note> = mutableListOf()
)
