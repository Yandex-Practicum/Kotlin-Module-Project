class ArchiveOfNotes(override val title: String) : MenuListInterface {

    override val titlesList: MutableMap<Int, Note> = mutableMapOf()

    override fun addContent(title: String ) {
        val nextKey = titlesList.size + 1
        titlesList[nextKey] = Note(title)
    }

    fun getName() : String {
        return title
    }

    fun printMenu(currentMenu: ArchiveOfNotes, returnNumber: Int) {
        println("0. Создать заметку")
        for (i in currentMenu.titlesList.keys) {
            println("${i}. ${currentMenu.titlesList[i]}")
        }
        println("$returnNumber. Назад")
    }

}