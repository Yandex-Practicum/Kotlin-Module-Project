package screens

import model.MenuItem
import java.util.*

object MenuUtils {

    fun getChoice(elements: MutableList<MenuItem>): Int? {
        val choice = Scanner(System.`in`).nextLine()
        if (!isNumber(choice)) {
            println("Ошибка ввода, введите число.")
            return null
        }
        if (elements.lastIndex + 1 < choice.toInt()) {
            println("Такого пункта меню нет.")
            return null
        }
        return choice.toInt()
    }

    fun goToMenuItem(index: Int, elements: MutableList<MenuItem>) {
        for (element in elements) {
            if (element.number == index) {
                if (element.operation != null) {
                    element.operation.invoke()
                }
            }
        }
    }

    fun printMenu(title: String, elements: MutableList<MenuItem>) {
        println(title)
        for (element in elements) {
            println(element)
        }
    }

    private fun isNumber(string: String): Boolean {
        return try {
            string.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}