fun main() {
    // ваш код начнется здесь
    // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
    val listOfArchives = ListOfArchives()
    val newArchive = ArchiveOfNotes("newArchive", listOfArchives)
    val newNote = Note("newNote", newArchive)
    //newNote.content = "NoteNoteNote"
    //newArchive.archiveOfNotes.add(newNote)
    //listOfArchives.listOfArchives.add(newArchive)
    var currentMenu: Notes = listOfArchives
//    val menu = MenuScreen(listOfArchives, null)
    val newInput = Logic()
    val regexCheck = "[0-9]".toRegex()

    fun printMenu(returnNumber: Int) {
        println("0. Создать архив")
        for (each in currentMenu.titlesList) {
            println("${each.key}. $each")
        }
//        for (i in menu.titlesList.indices){
//            println("${i + 1}. ${menu.titlesList[i]}")
//        }
        println("$returnNumber. Выход")
    }
    while(true) {
        val returnNumber = currentMenu.titlesList.size + 1
        printMenu(returnNumber)
        val userInput = newInput.askForInput("Please, choose an option and enter a corresponding number")
        if (currentMenu.titlesList.keys.contains(userInput.toInt())) {
            continue
        }
        when (userInput.toInt()) {
            returnNumber -> {
                if (currentMenu is ListOfArchives) return else currentMenu = currentMenu.parent
            }
            0 -> {
                val newTitle = newInput.askForInput("Please, input a title")
                currentMenu.addContent(newTitle, currentMenu)
                continue
            }
            else -> currentMenu: Notes = currentMenu.titlesList[userInput]
        }
    }
//in menu.keys //if menu will be a map of menu option number and a lambda

}
