class ListOfArchives() {
    val titlesList = mutableMapOf<Int, ArchiveOfNotes>()
    val parent = this

    fun addContent(title: String, parent: ListOfArchives ) {
        val nextKey = titlesList.size + 1
        titlesList[nextKey] = ArchiveOfNotes(title, parent)
    }
}