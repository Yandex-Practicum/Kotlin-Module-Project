package storage

import archives.model.Archive
import notes.model.Note

class LocalDataSource {
    private val archives: MutableList<Archive> = mutableListOf()
    private val notes: MutableList<Note> = mutableListOf()

    fun getAllArchives(): List<Archive> {
        return archives.toList()
    }

    fun getAllNotes(parentId: Int): List<Note> {
        return notes.toList().filter { it.parentId == parentId }
    }

    fun resolveArchive(id: Int): Archive? {
        return archives.firstOrNull { it.id == id }
    }

    fun resolveNote(id: Int): Note? {
        return notes.firstOrNull { it.id == id }
    }

    fun addNote(title: String, text: String, parentId: Int) {
        notes.add(
            Note(
                title = title,
                text = text,
                id = (notes.lastIndex + 1),
                parentId = parentId
            )
        )
    }

    fun addArchive(title: String) {
        archives.add(
            Archive(
                name = title,
                id = (archives.lastIndex + 1)
            )
        )
    }

    companion object {
        private var source: LocalDataSource? = null
        fun getInstance(): LocalDataSource {
            return synchronized(this) {
                val instance = source
                if (instance == null) {
                    val created = LocalDataSource()
                    source = created
                    created
                } else {
                    instance
                }
            }
        }
    }
}
