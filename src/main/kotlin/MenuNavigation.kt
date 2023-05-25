
import java.util.Scanner

class MenuNavigation {

    fun showViewMenu (menuPage: ViewInterface) {
        menuPage.prepareToView()
        println("Выберите пункт ")
        println(menuPage.title)
        var count = 0
        val tempMenu = mutableMapOf<Int, String>()

        for (element in menuPage.mapOfMenu) {
            count++
            tempMenu.put(count, element.key)
            println("$count. ${element.key}")

        }

        var userInput: String = getUserInput()

        while (!checkUserInput(userInput, count)) {
            println("Некорректный ввод! Введите цифру согласно пункту меню от 1 до $count")
            for (key in tempMenu.keys) {
                println("$key. ${tempMenu[key]}")
            }
            userInput = getUserInput()
        }

        menuPage.mapOfMenu[tempMenu[userInput.toInt()]]?.invoke()
    }


    private fun checkUserInput(userInput: String, count: Int): Boolean {
        return ((isInputInt(userInput)) && (userInput.toInt() in 0..count) && (userInput != "0"))
    }

    private fun isInputInt(str: String): Boolean {
        return if (str.isEmpty() && str.length <= 3) false else str.all { Character.isDigit(it) }
    }

    fun showCreateMenu (menuPage: CreateInterface) {
        menuPage.createFromInput()
    }

    fun getUserInput () : String {
        return Scanner(System.`in`).nextLine()
    }


}