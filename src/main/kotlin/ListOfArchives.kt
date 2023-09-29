data object ListOfArchives : Entity {
    private val archives = mutableListOf<Archive>()
    fun addArchive(archive: Archive) = archives.add(archive)
    fun getListOfArchives() = archives
}