class ArchiveMakeScreen {
    private val utils = Utils()
    private val repository = RepositoryObject.repository

    fun addArchive() {
        println("------")
        println("Введите название архива:")
        val name = utils.readString()
        repository.add(ArchiveEntity(name))
    }
}