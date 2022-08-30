class ArchiveOfNotes (val title: String, val parent: Notes) : Notes {

    private val archiveOfNotes: MutableList<Note> = mutableListOf()

    override fun getListOfTitles(): MutableList<String> {
        val list: MutableList<String> = mutableListOf()
        for(each in archiveOfNotes) {
            list.add(each.title)
        }
        return list
    }
}