class ArchiveMakeScreen {
    private val utils = Utils()

    fun addArchive() {
        println("======")
        print("Введите название архива: ")
        val name = utils.readString()
        RepositoryObject.addArchive(ArchiveEntity(name))
    }
}