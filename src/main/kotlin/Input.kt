import java.util.Scanner

class Input {
    companion object {
        var scanner = Scanner(System.`in`)

        fun intInput(menuSize: Int): Int {
            var input = -1

            do {
                try {
                    println("Введите номер пункта меню:")
                    input = scanner.nextLine().toInt()
                    if (input > menuSize) {
                        println("Такой пункт отсутствует")
                        input = -1
                    }
                } catch (e: Exception) {
                    println("Необоходимо ввести число.")
                }
            } while (input < 0)
            return input
        }

        fun textInput(prompt: String, maxLength: Int): String {

            var input = ""
            val max = maxLength

            do {
                println(prompt)
                input = scanner.nextLine().trim()
                when (input.length) {
                    in 1..max -> return input
                    in 0..0 -> println("Значение не может быть пустым")
                    else -> {
                        println("Введено слишком длинное значение")
                        input = ""
                    }
                }
            } while (input == "")
            return input
        }
    }
}