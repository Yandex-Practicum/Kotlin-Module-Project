class ArchiveManager {
    private val archives = mutableListOf<Archive>()

    fun createArchive(name: String) {
        archives.add(Archive(name))
    }

    fun getArchives(): List<Archive> {
        return archives.toList()
    }
}