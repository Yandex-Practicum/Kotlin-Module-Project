fun main() {

    var listOfArchivesMenu = ListOfArchives()
    var listOfNotesMenu: ArchiveOfNotes? = null
    var noteContent: Note? = null

    val newInput = Logic()

    fun printMenu(currentMenu: ListOfArchives, returnNumber: Int) {
        println("0. Создать архив")
        for (each in currentMenu.titlesList) {
            println("${each.key}. $each")
        }
        println("$returnNumber. Выход")
    }

    fun checkedInputArchives(userInput: String, returnNumber: Int) : Int? {
        val userInputInt = userInput.toIntOrNull() ?: return null
        if (listOfArchivesMenu.titlesList.keys.contains(userInputInt) ||
            userInputInt == 0 || userInputInt == returnNumber) {
            return userInputInt
        } else {
            return null
        }
    }

    fun checkedInputNotes(userInput: String, returnNumber: Int) : Int? {
        val userInputInt = userInput.toIntOrNull() ?: return null
        if (listOfNotesMenu != null) {
            if (listOfNotesMenu.titlesList != null) {

                }
        } else if (listOfNotesMenu.titlesList.keys.contains(userInputInt) ||
            userInputInt == 0 || userInputInt == returnNumber) {
            return userInputInt
        } else {
            return null
        }
    }
    while (true) {
        if (listOfNotesMenu == null && noteContent == null) {
            val returnNumber = listOfArchivesMenu.titlesList.size + 1
            printMenu(listOfArchivesMenu, returnNumber)
            val userInput =
                newInput.askForInput("Please, choose an option and enter a corresponding number")
            val validInput = checkedInput(userInput, returnNumber) ?: continue
            when (validInput) {
                returnNumber -> return
                0 -> {
                    val newTitle = newInput.askForInput("Please, input a title")
                    listOfArchivesMenu.addContent(newTitle, listOfArchivesMenu)
                    continue
                }
                else -> {
                    listOfNotesMenu = listOfArchivesMenu.titlesList[validInput]
                    continue
                }
            }
        } else if (listOfNotesMenu != null && noteContent == null) {
            val returnNumber = listOfNotesMenu.titlesList.size + 1
            listOfNotesMenu.printMenu(listOfNotesMenu, returnNumber)
            val userInput =
                newInput.askForInput("Please, choose an option and enter a corresponding number")

            val validInput = checkedInput(userInput, returnNumber) ?: continue
            when (validInput) {
                returnNumber -> {
                    listOfNotesMenu = null
                    continue
                }
                0 -> {
                    val newTitle = newInput.askForInput("Please, input a title")
                    listOfNotesMenu.addContent(newTitle, listOfNotesMenu)
                    continue
                }
                else -> {
                    noteContent = listOfNotesMenu.titlesList[validInput]
                    println(noteContent?.title)
                    println("0. Выход")
                    val returnInput =
                        newInput.askForInput("Please, enter 0 to return")
                    val validInput = checkedInput(userInput, returnNumber) ?: continue
                    noteContent = null
                }
            }
        }
    }
}