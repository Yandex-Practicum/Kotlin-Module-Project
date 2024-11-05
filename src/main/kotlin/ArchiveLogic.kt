class ArchiveLogic {
    private val archiveList = mutableListOf<Archive>()

    public fun createNewArchive(name: String): Boolean{
        val archive = Archive(name)
        if (archiveList.none {it.getName() == name})
        {
            archiveList.add(archive)
            return true
        }
        return false
    }

    public fun getListOfArchives(): Array<String>{
        return archiveList.map {it.getName()}.toTypedArray()
    }

    public fun getArchive(name: String): Archive?{
        return archiveList.find { it.getName() == name }
    }
}