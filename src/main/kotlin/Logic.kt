import java.util.Scanner

class Logic {

    fun askForInput(message: String): String {
        println(message)
        return Scanner(System.`in`).nextLine()
    }

//    fun <T>printMenu(currentMenu: T, returnNumber: Int) {
//        println("0. Создать архив")
//        for (each in currentMenu.get(titlesList) {
//            println("${each.key}. $each")
//        }
//        println("$returnNumber. Выход")
//    }
}