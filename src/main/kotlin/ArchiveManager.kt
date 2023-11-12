object ArchiveManager {
    val archives = mutableListOf<Archive>()

    fun addArchive(archive: Archive) {
        archives.add(archive)
    }
}