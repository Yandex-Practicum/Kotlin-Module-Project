import java.util.Scanner

class Logic(var currentMenu: AbstractNotes) {

    private var menuList: MutableList<String> = mutableListOf()
    private var menuFunctions: MutableList<() -> Unit> = mutableListOf()
    var needExit = false

    fun makeMenu() {
        val previousMenu = currentMenu.getPrevious()
        if (currentMenu is Note) {
            println(currentMenu.title)
        } else if (currentMenu is MenuInterface<*>) {
            menuList.add("Create new")
            menuFunctions.add { (currentMenu as MenuInterface<*>).addContent(askForInput("Please, input a title")) }
            val titles = (currentMenu as MenuInterface<*>).getTitles()
            if (titles.isNotEmpty()) {
                for (i in titles.indices) {
                    menuList.add(titles[i])
                    menuFunctions.add {
                        currentMenu = (currentMenu as MenuInterface<*>).getContent(i + 1)
                    }
                }
            }
        }
        menuList.add("Exit")
        menuFunctions.add {
            if (currentMenu != previousMenu) {
                currentMenu = previousMenu
            } else needExit = true
        }
    }

    fun printMenu() {
        for (i in menuList.indices) {
            println("$i. ${menuList[i]}")
        }
    }

    fun clearMenu() {
        menuList.clear()
        menuFunctions.clear()
    }

    fun doMenuOption(userChoice: Int) {
        menuFunctions[userChoice]()
    }

    fun getValidUserInput(message: String): Int? {
        return getValidInput(askForInput(message))
    }

    private fun askForInput(message: String): String {
        println(message)
        return Scanner(System.`in`).nextLine()
    }

    private fun getValidInput(userInput: String): Int? {
        val userInputInt = userInput.toIntOrNull() ?: return null
        return if (userInputInt in menuList.indices) userInputInt else null
    }
}
