import java.util.Scanner

class InputAndChecking {

    companion object {
        private val scanner: Scanner = Scanner(System.`in`)
        fun inputInt(): Int {                               //Функция получающая Int, включая проверку и повторный ввод
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


        fun inputString(): String {                         //Ввод текста
            return scanner.nextLine()
        }


        fun checkInt(s: String): Boolean {                   //Проверяет введены ли цифры
            return try {
                s.toInt()
                true
            } catch (ex: NumberFormatException) {
                false
            }
        }

        fun String.intOrString(): Any {
            return when(val v = toIntOrNull()) {
                null -> this
                else -> v
            }
        }


        fun isInt(i: String) : Any {
            if(i.intOrString() is Int) {
               return  i.toInt()
            } else {
                return i
            }
        }
    }
}