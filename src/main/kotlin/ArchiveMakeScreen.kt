class ArchiveMakeScreen {
    private val utils = Utils()

    fun addArchive() {
        val repository = RepositoryObject.repository

        println("======")
        print("Введите название архива: ")
        val name = utils.readString()
        repository.add(ArchiveEntity(name))
    }
}