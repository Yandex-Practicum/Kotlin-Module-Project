package Menu

import java.util.*

abstract class Menu {
    fun handleExceptions(amountElements: Int): Int {
        while (true) {
            try {
                val userInputMenuItem = Scanner(System.`in`).nextInt()
                if (userInputMenuItem > amountElements) {
                    println("Введите число в рамках предложенных вариантов")
                    continue
                }
                return userInputMenuItem
            } catch (e: java.util.InputMismatchException) {
                println("Введите число в рамках предложенных вариантов")
            }
        }
    }
}