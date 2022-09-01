import java.util.Scanner

class Logic <T: MenuListInterface> {

    currentMenu: MenuListInterface =

    private val menuList: MutableList<()->Unit> = mutableListOf()

    fun <X: MenuListInterface> printMenu(currentMenu: X, returnNumber: Int) {

        println("0. Создать архив")

        for (i in currentMenu.titlesList.keys) {
            println("$i. ${currentMenu.titlesList[i]?.title}")
        }

        println("$returnNumber. Выход")

    }

    fun <Y: MenuListInterface> getMenuUsage (currentMenu: Y, returnNumber: Int, validInput: Int) {

        menuList[0] = {currentMenu.addContent(askForInput("Please, input a title"))}

        for (i in currentMenu.titlesList.keys){
            menuList[i] = {changeMenu(currentMenu, currentMenu.titlesList[validInput])}
        }
// #TODO fix changeMenu (can't work from inside Logic with var from Main)
        println("$returnNumber. Выход")
    }


    fun askForInput(message: String): String {
        println(message)
        return Scanner(System.`in`).nextLine()
    }

    fun <W: MenuListInterface> getValidInput (currentMenu: W, userInput: String, returnNumber: Int) : Int? {
        val userInputInt = userInput.toIntOrNull() ?: return null
        if (currentMenu.titlesList.keys.contains(userInputInt) ||
            userInputInt == 0 || userInputInt == returnNumber) {
            return userInputInt
        } else {
            return null
        }
    }

}