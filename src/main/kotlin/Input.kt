import java.util.Scanner

class Input {

    companion object {
        private val scanner: Scanner = Scanner(System.`in`)
        fun inputInt(): Int {                               //Цикл получающий Int, включая проверку и повторный ввод
            val input: String = scanner.nextLine()
            var outInt: Int = 0
            if (checkInt(input)) {
                outInt = input.toInt()
                return outInt
            } else {
                println("Введите цифру меню")
                inputInt()
            }
            return outInt
        }


        private fun checkInt(s: String): Boolean {                   //Проверяет введены ли цифры
            return try {
                s.toInt()
                true
            } catch (ex: NumberFormatException) {
                false
            }
        }
    }
}