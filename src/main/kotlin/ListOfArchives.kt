class ListOfArchives() : Notes {
    private val listOfArchives: MutableList<ArchiveOfNotes> = mutableListOf()

    override fun getListOfTitles(): MutableList<String> {
        val list: MutableList<String> = mutableListOf()
        for(each in listOfArchives) {
            list.add(each.title)
        }
        return list
    }
}