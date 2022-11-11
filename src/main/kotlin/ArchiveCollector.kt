class ArchiveCollector : Menu<Archive>() {

    override var first: String = "Создать архив"
    var archiveLast: Archive = Archive()

    override fun execute() {
        var archive: Archive = Archive()
        collection.add(archive)
        archive.menu()
        archiveLast = archive
        action()
    }

    fun action() {
        while (true) {
            when (val input: Int = archiveLast.input()) {
                0 -> {
                    archiveLast.execute()
                }
                archiveLast.collection.size + 1 -> {

                    return
                }
                else -> {
                    collection[input - 1].menu()
                    collection[input - 1].action()
                }
            }
        }
    }
}