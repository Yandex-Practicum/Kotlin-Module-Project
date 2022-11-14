fun main() {
    val archiveCollector = ArchiveBox()
    while (true) {
        archiveCollector.menu()
        when (val input: Int = archiveCollector.input()) {
            0 -> archiveCollector.execute()
            archiveCollector.collection.size + 1 -> break
            else -> {
                archiveCollector.collection[input - 1].menu()
                archiveCollector.collection[input - 1].action()
            }
        }
    }
}