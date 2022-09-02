fun main() {

    val listOfArchivesMenu = ListOfArchives()
    var listOfNotesMenu: ArchiveOfNotes? = null
    var noteContent: Note? = null
    var currentMenu: MenuInterface = listOfArchivesMenu

//    while (true) {
        val menuLogic = Logic(listOfArchivesMenu)
        println(menuLogic.menuList)
        println(currentMenu.getTitles())
        if (currentMenu is ListOfArchives) {
            val userInput =
                menuLogic.askForInput("Please, choose an option and enter a corresponding number")
            val validInput = menuLogic.getValidInput(userInput) ?: return // continue // possible issue
            menuLogic.menuList[validInput]
            println(currentMenu)
            println(currentMenu.getTitles())
        }
//    }
}
//    val menuSwitcher: List<MenuInterface?> =
//        listOf(listOfArchivesMenu, listOfNotesMenu, noteContent)
//    listOfArchivesMenu.getPrevious()
//    val menuLogic = Logic()
//    println(menuLogic.makeMenu(currentMenu, 2, 1))
/*
//    fun printMenu(currentMenu: ListOfArchives, returnNumber: Int) {
//
//        println("0. Создать архив")
//
//        for (i in currentMenu.titlesList.keys) {
//            println("$i. ${currentMenu.titlesList[i]?.getName()}")
//        }
//
//        println("$returnNumber. Выход")
//
//    }
//
//    fun checkedInput(userInput: String, returnNumber: Int) : Int? {
//
//        val userInputInt = userInput.toIntOrNull() ?: return null
//
//        if (listOfArchivesMenu.titlesList.keys.contains(userInputInt) ||
//            userInputInt == 0 || userInputInt == returnNumber) {
//            return userInputInt
//        } else {
//            return null
//        }
//
//    }*/

/*//    while (true) {
//        for (each in menuSwitcher) {
//            if (each != null) currentMenu = each
//        }
//        val returnNumber = currentMenu[0].titlesList.size + 1
//
//        var menuLogic: Logic<out MenuInterface>
//        if (listOfNotesMenu != null) {
//            menuLogic = Logic<ArchiveOfNotes>()
//        } else if (noteContent != null) {
//           menuLogic = Logic<Note>()
//        } else {
//            menuLogic = Logic<ListOfArchives>()
//        }
//
//        menuLogic.printMenu(currentMenu, returnNumber)
//        val userInput = menuLogic.askForInput("Please, choose an option and enter a corresponding number")
//        val validInput = menuLogic.getValidInput(currentMenu, userInput, returnNumber)?: continue
//        menuLogic.getMenuUsage(currentMenu,returnNumber, validInput)
*/
/*//        if (listOfNotesMenu == null && noteContent == null) {
//
//            val returnNumber = listOfArchivesMenu.titlesList.size + 1
//            printMenu(listOfArchivesMenu, returnNumber)
//
//            val userInput =
//                newInput.askForInput("Please, choose an option and enter a corresponding number")
//
//            val validInput = checkedInput(userInput, returnNumber) ?: continue
//
//            when (validInput) {
//
//                returnNumber -> return
//
//                0 -> {
//                    val newTitle = newInput.askForInput("Please, input a title")
//                    listOfArchivesMenu.addContent(newTitle)
//                    continue
//                }
//
//                else -> {
//                    listOfNotesMenu = listOfArchivesMenu.titlesList[validInput]
//                    continue
//                }
//            }
//
//        } else if (listOfNotesMenu != null && noteContent == null) {
//
//            val returnNumber = listOfNotesMenu.titlesList.size + 1
//
//            listOfNotesMenu.printMenu(listOfNotesMenu, returnNumber)
//
//            val userInput =
//                newInput.askForInput("Please, choose an option and enter a corresponding number")
//
//            val userInputInt = userInput.toIntOrNull() ?: continue
//
//            var validInput = 0
//
//            if (listOfNotesMenu.titlesList.contains(userInputInt)
//                || userInputInt == 0
//                || userInputInt == returnNumber) {
//                validInput = userInputInt
//            }
//
//            when (validInput) {
//
//                returnNumber -> {
//                    listOfNotesMenu = null
//                    continue
//                }
//
//                0 -> {
//                    val newTitle = newInput.askForInput("Please, input a title")
//                    listOfNotesMenu.addContent(newTitle, listOfNotesMenu)
//                    continue
//                }
//
//                else -> {
//                    noteContent = listOfNotesMenu.titlesList[validInput]
//                    println(noteContent?.title)
//                    continue
//                }
//            }
//
//        } else if (noteContent != null) {
//
//            println("0. Выход")
//
//            val returnInput =
//                newInput.askForInput("Please, enter 0 to return")
//
//            val userInputInt = returnInput.toIntOrNull() ?: continue
//
//            if (userInputInt == 0) {
//                noteContent = null
//                continue
//            }
//        }*/
