import java.util.Scanner

class Logic (val currentMenu: MenuInterface) {

    val menuList: MutableList<String> = mutableListOf()
    val menuFunctions: MutableList<()->Unit> = mutableListOf()

    init {
        menuList.add("Create new")
        menuFunctions.add { addContentFun }
    val titles = currentMenu.getTitles()
        if (titles.isNotEmpty()) {
            for (i in titles.indices) {
                menuList.add(titles[i])
                menuFunctions.add { getContentFun }
            }
            menuList.add("Exit")
            menuFunctions.add { println(this.currentMenu.getPrevious()) }
        }
        menuList.add("Exit")
        menuFunctions.add { println(this.currentMenu.getPrevious()) }
    }

    fun interface AddContent {
        fun create(currentMenu: MenuInterface)
    }

    fun interface GetContent {
        fun create(currentMenu: MenuInterface, userChoice: Int)
    }

    val addContentFun = AddContent{ currentMenu -> currentMenu.addContent(askForInput("Please, input a title"))}
    val getContentFun = GetContent{ currentMenu, it -> currentMenu.getContent(it) }

    fun doOptionMenuOption(userInput: String){
        return(menuFunctions[userInput])
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
}