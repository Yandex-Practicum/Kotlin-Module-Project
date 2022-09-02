import java.util.Scanner

class Logic (val currentMenu: MenuInterface) {

    val menuList: MutableList<Map<String, ()->Unit>> = mutableListOf()

    init {
        menuList[0] = mapOf("Create new" to {this.currentMenu.addContent(askForInput("Please, input a title"))})

        for (each in currentMenu.getTitles()){
            var i = 1
            menuList[i] = mapOf(each to {this.currentMenu.getContent(i)})
            i++
        }
        menuList[currentMenu.getTitles().size + 1] = mapOf("Exit" to {this.currentMenu.getPrevious()})
    }

    fun askForInput(message: String): String {
        println(message)
        return Scanner(System.`in`).nextLine()
    }

    fun getValidInput (currentMenu: MenuInterface, userInput: String, returnNumber: Int) : Int? {
        val userInputInt = userInput.toIntOrNull() ?: return null
        if (userInputInt in 0..currentMenu.getTitles().size + 1) {
            return userInputInt
        } else {
            return null
        }
    }


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


//    fun <P> changeMenu(currentMenu: P, menuSwitcher: List<MenuInterface?>) {
//
//    }





}