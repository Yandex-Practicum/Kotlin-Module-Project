fun main(args: Array<String>) {
    val archivesDatabase = mutableListOf<Archive>()

    val screens = Screens(archivesDatabase)
    screens.openArchiveMenu()
}
