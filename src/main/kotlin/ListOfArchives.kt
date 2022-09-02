class ListOfArchives : MenuInterface {
    override val parent: MenuInterface = this
    override val title = "Main Menu"
    private val contentList: MutableList<ArchiveOfNotes> = mutableListOf()

    override fun getTitles(): MutableList<String>  {
        val titlesList: MutableList<String> = mutableListOf()
        for (each in contentList) {
            titlesList.add(each.title)
        }
        return titlesList
    }

    override fun getContent(userChoice: Int) : ArchiveOfNotes {
        return contentList[userChoice - 1]
    }

    override fun addContent(title: String) {
        val nextKey = contentList.size
        contentList[nextKey] = ArchiveOfNotes(title, this)
    }

    val menuList: MutableList<MutableMap<String, ()->Unit>> = mutableListOf()

}