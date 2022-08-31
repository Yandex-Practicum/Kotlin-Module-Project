class ListOfArchives() {
    val titlesList = mutableMapOf<Int, ArchiveOfNotes>()

    fun addContent(title: String) {
        val nextKey = titlesList.size + 1
        titlesList[nextKey] = ArchiveOfNotes(title)
    }
}