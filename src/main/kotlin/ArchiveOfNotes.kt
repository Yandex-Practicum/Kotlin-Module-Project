class ArchiveOfNotes(override val title: String, override val parent: MenuInterface) : MenuInterface {

    val contentList: MutableList<Note> = mutableListOf()

    override fun addContent(title: String ) {
        val nextKey = contentList.size
        contentList[nextKey] = Note(title, this)
    }

    override fun getTitles(): MutableList<String>  {
        val titlesList: MutableList<String> = mutableListOf()
        for (each in contentList) {
            titlesList.add(each.getContent(0))
        }
        return titlesList
    }

    override fun getContent(userChoice: Int) : Note {
        return contentList[userChoice - 1]
    }



//    fun printMenu(currentMenu: ArchiveOfNotes, returnNumber: Int) {
//        println("0. Создать заметку")
//        for (i in currentMenu.titlesList.keys) {
//            println("${i}. ${currentMenu.titlesList[i]}")
//        }
//        println("$returnNumber. Назад")
//    }

}