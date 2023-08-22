import java.util.*

class Input() {

    companion object {
        val scanner: Scanner = Scanner(System.`in`)

        fun checkInt(input: String): Boolean{
            if (input.toIntOrNull() == null) {
                println("Некорректная команда. Пожалуйста, введите число")
                return false
            } else {
                return true
            }
        }
    }
}