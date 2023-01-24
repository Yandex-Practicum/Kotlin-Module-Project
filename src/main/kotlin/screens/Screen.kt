package screens

import data.Entity
import java.util.*

abstract class Screen<T : Entity>(private val title: String, private val list: MutableList<T>) {

    fun show() {
        println()
        println("Список с $title'ами открыт")
        while (true) {
            println("Меню:\n0 - Создать 1 $title.")
            if (list.isNotEmpty()) {
                println("Для открытия введите номер из списка ниже:")
                list.forEachIndexed { id, entity -> println("${id + 1}. ${entity.title}") }
            } else {
                println("Список пуст. Необходимо создать хотя бы 1 $title.")
            }
            println("Для выхода введите ${list.size + 1}")

            try {
                when (val num: Int = Scanner(System.`in`).nextInt()) {
                    0 -> add()
                    in 1..list.size -> select(num - 1)
                    list.size + 1 -> exit()
                    else -> println("Введено неверное значение. Введите число от 0 до ${list.size + 1}")

                }
            } catch (ex: InputMismatchException) {
                println()
                println("Ошибка! Необходимо ввести цифру!")
                println()
            }
        }
    }

    abstract fun add()
    abstract fun select(i: Int)
    abstract fun exit()

}