import java.util.Scanner

open class CommonFunctions<T : Any> {

    open var elements: MutableList<T> = mutableListOf()
    open fun createElement() {

    }

    open fun openElement(t: T) {

    }

    fun getCommand(elements: MutableList<T>): Int {
        var number: String = Scanner(System.`in`).nextLine()
        while (true)
            number = if (checkNumber(number)) {
                println("Неправильный ввод, Вы ввели символ или слово. Нужно ввести цифру")
                Scanner(System.`in`).nextLine()
            } else if ((number.toInt() > (elements.size + 1)) or (number.toInt() < 0)) {
                println("Неправильный ввод, такого пункта нет в меню")
                Scanner(System.`in`).nextLine()
            } else return number.toInt()
    }

    fun logic(number: Int, elements: MutableList<T>) {
        when (number) {
            0 -> {
                createElement()
            }
            (elements.size + 1) -> {
                return
            }
            else -> {
                openElement(elements[number - 1])
            }
        }

    }

    private fun checkNumber(string: String): Boolean {
        return try {
            string.toInt()
            false
        } catch (e: NumberFormatException) {
            true
        }
    }
}