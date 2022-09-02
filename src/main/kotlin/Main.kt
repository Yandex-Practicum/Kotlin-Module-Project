fun main() {
    val initialPromptPhrase = "Please choose an option and enter a corresponding number"
    val listOfArchivesMenu = ListOfArchives()
//    var listOfNotesMenu: ArchiveOfNotes? = null
//    var noteContent: Note? = null
//    val currentMenu: MenuInterface = listOfArchivesMenu
    val menuLogic = Logic(listOfArchivesMenu)
    while (true) {
        menuLogic.clearMenu()
        menuLogic.makeMenu()
        menuLogic.printMenu()
        val getValidUserInput = menuLogic.getValidUserInput(initialPromptPhrase) ?: continue
        menuLogic.doMenuOption(getValidUserInput)
        if (menuLogic.needExit) break
    }
}
