import java.util.Scanner

class Logic <T: MenuInterface> {


    private val menuList: MutableList<()->Unit> = mutableListOf()

    fun <X: MenuInterface> printMenu(currentMenu: X, returnNumber: Int) {

        println("0. Создать архив")

        for (i in currentMenu.contentList.indices) {
            println("${i+1}. ${currentMenu.contentList[i].title}")
        }

        println("$returnNumber. Выход")

    }

    fun <Y: MenuInterface> getMenuUsage (currentMenu: Y, returnNumber: Int, validInput: Int) {

        menuList[0] = {currentMenu.addContent(askForInput("Please, input a title"))}

        for (i in currentMenu.contentList.indices){
            menuList[i] = menuList[i]
//            menuList[i] = {changeMenu(currentMenu, currentMenu.titlesList[validInput])}
        }
// #TODO fix changeMenu (can't work from inside Logic with var from Main)
        println("$returnNumber. Выход")
    }

    fun <P> changeMenu(currentMenu: P, menuSwitcher: List<MenuInterface?>) {

    }

    fun askForInput(message: String): String {
        println(message)
        return Scanner(System.`in`).nextLine()
    }

    fun <W: MenuInterface> getValidInput (currentMenu: W, userInput: String, returnNumber: Int) : Int? {
        val userInputInt = userInput.toIntOrNull() ?: return null
        if (
            currentMenu.contentList.indices.contains(userInputInt)
            || userInputInt == currentMenu.contentList.size + 1 || userInputInt == returnNumber
            ) {
            return userInputInt
        } else {
            return null
        }
    }



}