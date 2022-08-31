class ArchiveOfNotes (val title: String, val parent: ListOfArchives) {

    val titlesList: MutableMap<Int, Note> = mutableMapOf()

    fun addContent(title: String, parent: ArchiveOfNotes ) {
        val nextKey = titlesList.size + 1
        titlesList[nextKey] = Note(title, parent)
    }

    fun printMenu(currentMenu: ArchiveOfNotes, returnNumber: Int) {
        println("0. Создать заметку")
        for (each in currentMenu.titlesList) {
            println("${each.key}. $each")
        }
        println("$returnNumber. Назад")
    }

}