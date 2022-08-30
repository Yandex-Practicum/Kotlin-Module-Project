class ArchiveOfNotes (val title: String, override val parent: Notes) : Notes {

    override val titlesList: MutableMap<Int, Note> = mutableMapOf()

    override fun getListOfContent(): MutableList<Int> {
        val list: MutableList<Int> = mutableListOf()
        for(each in titlesList) {
            list.add(each.key)
        }
        return list
    }

    fun addContent(title: String, parent: Notes) {
        val nextKey = titlesList.size + 1
        titlesList[nextKey] = Note(title, parent)
    }

}