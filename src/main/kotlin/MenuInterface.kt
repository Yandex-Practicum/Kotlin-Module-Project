interface MenuInterface <T: AbstractNotes> {
//    abstract val parent: MenuInterface
//    abstract val title: String
    abstract val contentList: MutableList<T>

    abstract fun addContent(title: String)

//    fun getPrevious(): MenuInterface {
//        return parent
//    }

    fun getTitles(): MutableList<String> {
        val titlesList: MutableList<String> = mutableListOf()
        for (each in contentList) {
            titlesList.add(each.title)
        }
        return titlesList
    }

    fun getContent(userChoice: Int) : AbstractNotes


}