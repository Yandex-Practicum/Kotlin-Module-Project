import java.lang.Exception
import java.lang.NumberFormatException
import java.util.Scanner
import javax.xml.stream.events.Characters

class MenuNavigation {

    fun showViewMenu (menuPage: ViewInterface) {
        menuPage.prepareToView()
        println("Выберите пункт ")
        println(menuPage.title)
        var count: Int = 0
        val tempMenu = mutableMapOf<Int, String>()

        for (element in menuPage.mapOfMenu) {
            count++
            tempMenu.put(count, element.key)
            println("$count. ${element.key}")

        }

        var userInput: String = Scanner(System.`in`).nextLine()

        while (!checkUserInput(userInput, count)) {
            println("Некорректный ввод! Введите цифру согласно пункту меню от 1 до $count")
            for (key in tempMenu.keys) {
                println("$key. ${tempMenu[key]}")
            }
            userInput = readln()
        }

        menuPage.mapOfMenu[tempMenu[userInput.toInt()]]?.invoke()
    }


    private fun checkUserInput(userInput: String, count: Int): Boolean {
        return ((isInputInt(userInput)) && (userInput.toInt() in 0..count))
    }

    fun isInputInt(str: String): Boolean {
        return if (str.isNullOrEmpty()) false else str.all { Character.isDigit(it) }
    }

    fun showCreateMenu (menuPage: CreateInterface) {
        menuPage.createFromInput()
    }

    fun getUserInput () : String {
        return Scanner(System.`in`).nextLine()
    }


}