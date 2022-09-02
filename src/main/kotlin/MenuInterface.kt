interface MenuInterface<T : AbstractNotes> {

    val contentList: MutableList<T>

    fun addContent(title: String)

    fun getTitles(): MutableList<String> {
        val titlesList: MutableList<String> = mutableListOf()
        for (each in contentList) {
            titlesList.add(each.title)
        }
        return titlesList
    }

    fun getContent(userChoice: Int): AbstractNotes

}