class ListOfArchives() {
    val titlesList = mutableMapOf<Int, ArchiveOfNotes>()
    val parent = this

//    override fun getTitlesList() : MutableMap<Int, ArchiveOfNotes>{
//        return titlesList
//    }


//    fun getListOfContent(): MutableList<Int> {
//        val list: MutableList<Int> = mutableListOf()
//        for(each in titlesList) {
//            list.add(each.key)
//        }
//        return list
//    }



    fun addContent(title: String, parent: ListOfArchives ) {
        val nextKey = titlesList.size + 1
        titlesList[nextKey] = ArchiveOfNotes(title, parent)
    }
}