package data

import data.model.Archive

class StorageOfNotes {
    private val storage = arrayListOf<Archive>()

    fun getArchiveTitle(): List<String> {
        return storage.map { it.title }
    }

    fun getArchive(key: Int): Archive {
        return storage[key]
    }

    fun addArchive(archive: Archive) {
        storage.add(archive)
    }
}