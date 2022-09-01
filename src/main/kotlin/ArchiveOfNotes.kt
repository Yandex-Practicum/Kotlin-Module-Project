class ArchiveOfNotes(override val title: String, override val parent: MenuInterface) : MenuInterface {

    override val contentList: MutableList<Note> = mutableListOf()

    override fun addContent(title: String ) {
        val nextKey = contentList.size
        contentList[nextKey] = Note(title, this)
    }

//    fun getName() : String {
//        return title
//    }

//    fun printMenu(currentMenu: ArchiveOfNotes, returnNumber: Int) {
//        println("0. Создать заметку")
//        for (i in currentMenu.titlesList.keys) {
//            println("${i}. ${currentMenu.titlesList[i]}")
//        }
//        println("$returnNumber. Назад")
//    }

}