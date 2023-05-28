package utils

import java.util.*

/*
Класс по обработки ввода текста с клавиатуры
Выбор пункта меню на каждом экране должен корректно реагировать на неправильный ввод:
Если человек ввёл не цифру, то программа должна сказать ему, что следует вводить цифру, и ещё раз показать пункты меню.
Если человек ввёл цифру, но такого элемента нет на экране, то программа должна сказать, что такой цифры нет, снова показать пункты меню и предложить
ввести корректный символ.
 */
open class ScanEnter {

    private val scanner = Scanner(System.`in`)

    fun validateInt(maxNumber: Int): Int {
        while (true) {

            val str = scanner.nextLine().toIntOrNull() ?: -1

            if (str > maxNumber || str <= -1) {
                print("Введите число от 0 до $maxNumber! Пожалуйста повторите: ")
                continue
            }

            return str
        }
    }

    fun validateString(): String {

        while (true) {

            val str = scanner.nextLine().trimStart()

            if (str.isEmpty()) {
                print("Введенная строка не должна быть пустой. Пожалуйста повторите: ")
                continue
            }

            return str
        }
    }

}