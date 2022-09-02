fun main() {
    val initialPromptPhrase = "Please choose an option and enter a corresponding number"
    val listOfArchivesMenu: AbstractNotes = ListOfArchives()
    val menuLogic = Logic(listOfArchivesMenu)
    var getValidUserInput: Int

    while (true) {
        menuLogic.clearMenu()
        menuLogic.makeMenu()
        menuLogic.printMenu()

        getValidUserInput = menuLogic.getValidUserInput(initialPromptPhrase) ?: continue

        menuLogic.doMenuOption(getValidUserInput)

        if (menuLogic.needExit) break
    }
}
