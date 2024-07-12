class Archive(val name: String) {
    val notes = mutableListOf<Note>()
}


class Note(val title: String, val text: String)


class ArchiveManager {
    private val archives = mutableListOf<Archive>()

    fun addArchive(name: String) {
        archives.add(Archive(name))
    }

    fun getArchives(): List<Archive> {
        return archives
    }

    fun getArchive(index: Int): Archive? {
        return if (index in archives.indices) archives[index] else null
    }
}