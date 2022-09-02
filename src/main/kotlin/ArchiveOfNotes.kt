class ArchiveOfNotes : AbstractNotes(val title: String, val parent: MenuInterface),MenuInterface  {

    private val contentList: MutableList<Note> = mutableListOf()

    override fun addContent(title: String) {
        contentList.add(Note(title, this))
    }

    override fun getTitles(): MutableList<String> {
        val titlesList: MutableList<String> = mutableListOf()
        for (each in contentList) {
            titlesList.add(each.getContent(0))
        }
        return titlesList
    }

    override fun getContent(userChoice: Int): Note {
        return contentList[userChoice - 1]
    }
}
