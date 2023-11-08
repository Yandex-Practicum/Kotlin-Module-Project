import java.util.Scanner

class MenuNavi {

    fun showViewMenu (menuPage: ViewInterface) {
        menuPage.prepareToView()
        println("Выберите опцию ")
        println(menuPage.title)
        var count = 0
        val nameArchive = mutableMapOf<Int, String>()

        for (element in menuPage.mapMenu) {
            count++
            nameArchive.put(count, element.key)
            println("$count. ${element.key}")
        }

        var userInput: String = getUserInput()

        while (!checkUserInput(userInput, count)) {
            println("Ошибка! Введите цифру согласно пункту в меню от 1 до $count")
            for (key in nameArchive.keys) {
                println("$key. ${nameArchive[key]}")
            }
            userInput = getUserInput()
        }
        menuPage.mapMenu[nameArchive[userInput.toInt()]]?.invoke()
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