import java.util.Scanner

class Logic (var currentMenu: MenuInterface) {

    val menuList: MutableList<String> = mutableListOf()
    val menuFunctions: MutableList<(Any?)-> Unit> = mutableListOf()
    var needExit = false

    fun makeMenu() {
        menuList.add("Create new")
        menuFunctions.add { currentMenu.addContent(askForInput("Please, input a title")) }
        val titles = currentMenu.getTitles()
        val previousMenu = currentMenu.getPrevious()
        if (titles.isNotEmpty()) {
            for (i in titles.indices) {
                menuList.add(titles[i])
                menuFunctions.add { currentMenu = currentMenu.getContent(i) as MenuInterface }
            }
//            menuList.add("Exit")
//            menuFunctions.add {
//                if (currentMenu != previousMenu){
//                    currentMenu = previousMenu
//                } else needExit = true
//            }
        }
        menuList.add("Exit")
        menuFunctions.add {
            if (currentMenu != previousMenu){
                currentMenu = previousMenu
            } else needExit = true
        }
    }

//    fun interface AddContent {
//        fun create(currentMenu: MenuInterface)
//    }
//
//    fun interface GetContent {
//        fun create(currentMenu: MenuInterface, userChoice: Int)
//    }

//    val addContentFun = AddContent{ currentMenu -> currentMenu.addContent(askForInput("Please, input a title"))}
//    val getContentFun = GetContent{ currentMenu, it -> currentMenu.getContent(it) }

    fun doMenuOption(userChoice: Int){
        menuFunctions[userChoice]
    }

    fun printMenu() {
        for (i in menuList.indices) {
            println("$i. ${menuList[i]}")
        }
    }

    fun getValidUserInput(message: String): Int? {
        return getValidInput(askForInput(message))
    }

    fun askForInput(message: String): String {
        println(message)
        return Scanner(System.`in`).nextLine()
    }

    private fun getValidInput (userInput: String) : Int? {
        val userInputInt = userInput.toIntOrNull() ?: return null
        return if (userInputInt in 0..currentMenu.getTitles().size + 1) userInputInt else null
        }
}
