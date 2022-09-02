fun main() {

    val listOfArchivesMenu = ListOfArchives()
    var listOfNotesMenu: ArchiveOfNotes? = null
    var noteContent: Note? = null
    var currentMenu: MenuInterface = listOfArchivesMenu

    while (true) {
        val menuLogic = Logic(listOfArchivesMenu)
        menuLogic.printMenu()
        println(currentMenu.getTitles())
        if (currentMenu is ListOfArchives) {
            val userInput = menuLogic.getValidUserInput("Please, choose an option and enter a corresponding number")
            val method : MethodMenu = {menuLogic.menuFunctions[validInput]}
            println(currentMenu)
            println(currentMenu.getTitles())
        }
    }
}
