package modules

data class Archive(val nameArchive: String, val notes: MutableList<Note> = mutableListOf())