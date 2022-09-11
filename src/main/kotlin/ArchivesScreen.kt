class ArchivesScreen {
    private val utils = Utils()
    private val repository = RepositoryObject.repository

    fun run() {
        while (true) {
            val repositorySize = repository.size
            utils.showMenu(repository)
            val input = utils.readNumber(repositorySize)
            if (input == 0) {
                ArchiveMakeScreen().addArchive()
            } else if (input == (repositorySize + 1)) {
                break
            } else {

            }
        }
    }

}