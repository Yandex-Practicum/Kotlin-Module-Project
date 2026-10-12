class ArchiveManager {
    val archives: MutableList<Archive> = mutableListOf()

    fun addArchive(archive: Archive) {
        archives.add(archive)
    }
}