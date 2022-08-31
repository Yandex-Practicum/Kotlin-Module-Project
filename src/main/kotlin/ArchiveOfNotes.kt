class ArchiveOfNotes(private val title: String) {

    val titlesList: MutableMap<Int, Note> = mutableMapOf()

    fun addContent(title: String, parent: ArchiveOfNotes ) {
        val nextKey = titlesList.size + 1
        titlesList[nextKey] = Note(title, parent)
    }

    fun getName() : String {
        return title
    }

    fun printMenu(currentMenu: ArchiveOfNotes, returnNumber: Int) {
        println("0. Создать заметку")
        for (i in currentMenu.titlesList.keys) {
            println("${i}. ${currentMenu.titlesList[i]?.title}")
        }
        println("$returnNumber. Назад")
    }

}