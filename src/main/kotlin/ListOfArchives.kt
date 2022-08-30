class ListOfArchives() : Notes {
    override val parent = this
    override val titlesList: MutableMap<Int, ArchiveOfNotes> = mutableMapOf()

    override fun getListOfContent(): MutableList<Int> {
        val list: MutableList<Int> = mutableListOf()
        for(each in titlesList) {
            list.add(each.key)
        }
        return list
    }

    fun addContent(title: String, parent: Notes) {
        val nextKey = titlesList.size + 1
        titlesList[nextKey] = ArchiveOfNotes(title, parent)
    }
}