class ArchivesScreen {
    private val utils = Utils()

    fun run() {
        val archives = RepositoryObject.repository

        while (true) {
            val numberOfArchives = archives.size
            utils.showMenu(entities = archives)
            val menuIndex = utils.readNumber(numberOfArchives)
            if (menuIndex == 0) {
                ArchiveMakeScreen().addArchive()
            } else if (menuIndex == (numberOfArchives + 1)) {
                break
            } else {
                NotesScreen().run(menuIndex)
            }
        }
    }
}