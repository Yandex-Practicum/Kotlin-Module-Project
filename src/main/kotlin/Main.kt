fun main() {

    val listOfArchivesMenu = ListOfArchives()
    var listOfNotesMenu: ArchiveOfNotes? = null
    var noteContent: Note? = null

    val newInput = Logic()

    fun printMenu(currentMenu: ListOfArchives, returnNumber: Int) {

        println("0. Создать архив")

        for (i in currentMenu.titlesList.keys) {
            println("$i. ${currentMenu.titlesList[i]?.getName()}")
        }

        println("$returnNumber. Выход")

    }

    fun checkedInput(userInput: String, returnNumber: Int) : Int? {

        val userInputInt = userInput.toIntOrNull() ?: return null

        if (listOfArchivesMenu.titlesList.keys.contains(userInputInt) ||
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
                    listOfArchivesMenu.addContent(newTitle)
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

            val userInputInt = userInput.toIntOrNull() ?: continue

            var validInput = 0

            if (listOfNotesMenu.titlesList.contains(userInputInt)
                || userInputInt == 0
                || userInputInt == returnNumber) {
                validInput = userInputInt
            }

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
                    continue
                }
            }

        } else if (noteContent != null) {

            println("0. Выход")

            val returnInput =
                newInput.askForInput("Please, enter 0 to return")

            val userInputInt = returnInput.toIntOrNull() ?: continue

            if (userInputInt == 0) {
                noteContent = null
                continue
            }
        }
    }
}