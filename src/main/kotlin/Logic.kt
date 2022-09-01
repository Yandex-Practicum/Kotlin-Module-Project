import java.util.Scanner

class Logic {


    private val menuList: MutableList<MutableMap<String, ()->Unit>> = mutableListOf()

//    fun <X: MenuInterface> printMenu(currentMenu: X, returnNumber: Int) {
//
//        println("0. Создать архив")
//
//        for (i in currentMenu.contentList.indices) {
//            println("${i+1}. ${currentMenu.contentList[i].title}")
//        }
//
//        println("$returnNumber. Выход")
//
//    }

//    fun getTitles(currentMenu: MenuInterface, index: Int): MutableList<String>  {
//        val titlesList: MutableList<String> = mutableListOf()
//        for (each in currentMenu.contentList) {
//            titlesList.add(each.title)
//        }
//        return titlesList
//    }

    fun makeMenu (
        currentMenu: List<MenuInterface>,
        returnNumber: Int,
        validInput: Int
//        menuSwitcher: List<MenuInterface?>
    ) {
        menuList[0] = mutableMapOf("Create new" to {currentMenu[0].addContent(askForInput("Please, input a title"))})

        for (each in currentMenu[0].getTitles()){
            var i = 1
            menuList[i] = mutableMapOf(each to {currentMenu[0] = currentMenu[0].getContent(i)})
            i++
//            menuList[i] = {changeMenu(currentMenu, currentMenu.titlesList[validInput])}
        }
// #TODO fix changeMenu (can't work from inside Logic with var from Main)
        println("$returnNumber. Выход")
    }

//    fun <P> changeMenu(currentMenu: P, menuSwitcher: List<MenuInterface?>) {
//
//    }

    fun askForInput(message: String): String {
        println(message)
        return Scanner(System.`in`).nextLine()
    }

    fun getValidInput (currentMenu: MenuInterface, userInput: String, returnNumber: Int) : Int? {
        val userInputInt = userInput.toIntOrNull() ?: return null
        if (
            currentMenu[0].contentList.indices.contains(userInputInt)
            || userInputInt == currentMenu.contentList.size + 1 || userInputInt == returnNumber
            ) {
            return userInputInt
        } else {
            return null
        }
    }



}