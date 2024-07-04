import java.util.Scanner

class UserInput {
    fun menuInput (num: Int) : Int {
        while (true) {
            val input = readlnOrNull()
            if (input!!.isEmpty()) {
                println("Ошибка: Пустая строка, введите цифру из пункта меню!")
            } else {
                val number = input.toIntOrNull()
                when (number) {
                    in 1 until num -> return input.toInt()
                    else -> println("Ошибка: Такой пункт меню отсутвует!")
                }
            }
        }
    }
    fun textInput () : String {
        while(true) {
            val sc = Scanner(System.`in`).nextLine()
            if (sc.isEmpty()) println("Ошибка: Пустая строка") else return sc
        }
    }
}