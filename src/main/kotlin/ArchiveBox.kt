class ArchiveBox : Navigation<Archive>() {
    override var first: String = "Создать архив"
    private var archiveLast: Archive = Archive()
    override fun execute() {
        val archive = Archive()
        collection.add(archive)
        archive.menu()
        archiveLast = archive
        action()
    }
    private fun action() {
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