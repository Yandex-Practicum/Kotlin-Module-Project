package Menu

import java.util.*

abstract class Menu {
    abstract val menuName: String

    fun handleExceptions(amountElements: Int): Int {
        val errorMessage = "Введите число в рамках предложенных вариантов"
        while (true) {
            try {
                val userInputMenuItem = Scanner(System.`in`).nextInt()
                if (userInputMenuItem > amountElements) {
                    println(errorMessage)
                    continue
                }
                if (userInputMenuItem < 0) {
                    println(errorMessage)
                    continue
                }
                return userInputMenuItem
            } catch (e: java.util.InputMismatchException) {
                println(errorMessage)
            }
        }
    }

    fun <E: MenuItem> showMenu(itemsList: MutableList<E>) {
        println(menuName)
        for(i in 0..itemsList.size - 1) {
            println("$i. ${itemsList.get(i).menuItem}")
        }
    }

}