package data

import model.Note

object Database {
    val archives: MutableMap<String, MutableList<Note>> = mutableMapOf()

    fun addArchive(archiveName: String) {
        archives[archiveName] = mutableListOf()
    }

    fun addNote(archive: String, note: Note) {
        archives[archive]?.add(note)
    }
}