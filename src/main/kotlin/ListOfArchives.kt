class ListOfArchives() : Notes {
    private val listOfArchives: MutableList<ArchiveOfNotes> = mutableListOf()

    override fun getListOfContent(): MutableList<String> {
        val list: MutableList<String> = mutableListOf()
        for(each in listOfArchives) {
            list.add(each.title)
        }
        return list
    }

    fun addContent(title: String, parent: Notes) {
        listOfArchives.add(ArchiveOfNotes(title, parent))
    }
}