class ListOfArchives() : MenuListInterface {
    override val title = "Main Menu"
    override val titlesList: MutableMap<Int, ArchiveOfNotes> = mutableMapOf()

    override fun addContent(title: String) {
        val nextKey = titlesList.size + 1
        titlesList[nextKey] = ArchiveOfNotes(title)
    }
}