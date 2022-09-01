class ListOfArchives() : MenuInterface {
    override val parent: MenuInterface? = null
    override val title = "Main Menu"
    override val contentList: MutableList<ArchiveOfNotes> = mutableListOf()

    override fun addContent(title: String) {
        val nextKey = contentList.size
        contentList[nextKey] = ArchiveOfNotes(title, this)
    }
}